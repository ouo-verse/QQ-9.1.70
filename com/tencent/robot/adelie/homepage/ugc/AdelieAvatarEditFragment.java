package com.tencent.robot.adelie.homepage.ugc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.homepage.create.view.AdeliePolarLightBkgView;
import com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import cooperation.qzone.QzoneIPCModule;
import d24.AdelieAvatarResult;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 d2\u00020\u0001:\u0001eB\u0007\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J7\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0014J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u001bH\u0014J&\u00102\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u000100H\u0014J\"\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0004H\u0016R\u0018\u0010;\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010V\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010NR\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^\u00a8\u0006f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Qh", "", "ci", "Rh", "Sh", "Landroid/content/Intent;", "data", "Wh", "Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "Ph", "Vh", "url", "Lcom/tencent/image/URLDrawable;", "Oh", "imageUrl", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "Fh", "", "colorAlpha", "", "stroke", "Landroid/graphics/drawable/Drawable;", "Ih", "Xh", "Landroid/widget/TextView;", "cropBtn", "cropType", "ai", "Zh", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "bkgView", "Lcom/tencent/mobileqq/widget/RoundImageView;", "D", "Lcom/tencent/mobileqq/widget/RoundImageView;", "avatarImageView", "E", "fullBodyImageView", "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/component/banner/BannerLayout;", "bannerLayout", "G", "Landroid/widget/TextView;", "changeAvatarBtn", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "useBtn", "I", "Ljava/lang/String;", "originImageUrl", "J", "avatarImageUrl", "K", "coverImageUrl", "L", "Ljava/lang/Integer;", "source", "Lcom/tencent/robot/adelie/homepage/utils/AdelieCroppingUtil$a;", "M", "Lcom/tencent/robot/adelie/homepage/utils/AdelieCroppingUtil$a;", "croppedImageData", "N", "originImageLocalUrl", "P", "Z", "hasCropAvatar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "hasCropCover", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarEditFragment extends QIphoneTitleBarFragment {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AdeliePolarLightBkgView bkgView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RoundImageView avatarImageView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RoundImageView fullBodyImageView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private BannerLayout bannerLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView changeAvatarBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QUIButton useBtn;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String originImageUrl;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String avatarImageUrl;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String coverImageUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Integer source = 0;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private AdelieCroppingUtil.AdelieCroppedImageData croppedImageData = new AdelieCroppingUtil.AdelieCroppedImageData(null, null, 3, null);

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String originImageLocalUrl;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasCropAvatar;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasCropCover;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "code", "", "a", "", "AVATAR_IMAGE_URL", "Ljava/lang/String;", "COVER_IMAGE_URL", "IS_FROM_ALBUM", "ORIGIN_IMAGE_URL", "SOURCE", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarEditFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent, int code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AdelieFragmentActivity.INSTANCE.b(context, intent, AdelieAvatarEditFragment.class, code);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lhn2/c;", "E", "Lhn2/c;", "l", "()Lhn2/c;", "binding", "<init>", "(Lhn2/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final hn2.c binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull hn2.c binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final hn2.c getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0002\u0000\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0017\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "com/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "(Landroid/view/ViewGroup;I)Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$b;", "getItemCount", "holder", "position", "", "i0", "(Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$b;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.Adapter<b> {
        final /* synthetic */ AdelieAvatarEditFragment C;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Integer[] f366493m;

        c(Integer[] numArr, AdelieAvatarEditFragment adelieAvatarEditFragment) {
            this.f366493m = numArr;
            this.C = adelieAvatarEditFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f366493m.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"UseCompatLoadingForDrawables"})
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Integer num;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Context context = this.C.getContext();
            if (context != null && (num = this.f366493m[position]) != null) {
                holder.getBinding().f405344b.setImageDrawable(context.getDrawable(num.intValue()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            hn2.c g16 = hn2.c.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026  false\n                )");
            return new b(g16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/homepage/ugc/AdelieAvatarEditFragment$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f366495b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f366496c;

        d(TextView textView, int i3) {
            this.f366495b = textView;
            this.f366496c = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            AdelieAvatarEditFragment.this.ai(this.f366495b, this.f366496c);
        }
    }

    private final void Fh(String imageUrl, final Function1<? super Boolean, Unit> callback) {
        boolean contains$default;
        final URLDrawable Oh = Oh(imageUrl);
        if (Oh != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) imageUrl, (CharSequence) "http", false, 2, (Object) null);
            if (!contains$default) {
                this.originImageLocalUrl = imageUrl;
                if (callback != null) {
                    callback.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarEditFragment.Hh(Function1.this, Oh, this);
                }
            }, 64, null, false);
            return;
        }
        if (callback != null) {
            callback.invoke(Boolean.FALSE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Gh(AdelieAvatarEditFragment adelieAvatarEditFragment, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        adelieAvatarEditFragment.Fh(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 function1, URLDrawable uRLDrawable, AdelieAvatarEditFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "adelie_avatar").getAbsolutePath()), "adelie_generated_avatar_image.png");
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            QLog.w("AdelieAvatarEditFragment", 1, "saveBitmap, parentFile is null ");
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            QLog.e("AdelieAvatarEditFragment", 1, "mkdir failed " + parentFile.getAbsolutePath());
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (uRLDrawable.getStatus() == 1) {
            this$0.originImageLocalUrl = uRLDrawable.saveTo(file.getPath());
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    private final Drawable Ih(float colorAlpha, int stroke) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        Context context = getContext();
        if (context != null) {
            gradientDrawable.setColor(CommonExKt.l(context.getColor(R.color.qui_common_fill_light_primary), colorAlpha));
        }
        gradientDrawable.setCornerRadius(c24.a.a(4));
        Context context2 = getContext();
        if (context2 != null) {
            gradientDrawable.setStroke(stroke, context2.getColor(R.color.qui_common_brand_standard));
        }
        return gradientDrawable;
    }

    static /* synthetic */ Drawable Jh(AdelieAvatarEditFragment adelieAvatarEditFragment, float f16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = 0.5f;
        }
        if ((i16 & 2) != 0) {
            i3 = c24.a.a(1);
        }
        return adelieAvatarEditFragment.Ih(f16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(AdelieAvatarEditFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.robot.adelie.homepage.utils.b.f366646a.a(this$0.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    public static final void Lh(AdelieAvatarEditFragment this$0, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            AdelieAvatarResult a16 = ad.INSTANCE.a();
            a16.d(this$0.croppedImageData.getAvatar());
            a16.e(this$0.croppedImageData.getCover());
            ?? r16 = this$0.hasCropAvatar;
            int i3 = r16;
            if (this$0.hasCropCover) {
                i3 = r16 + 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("crop_content", Integer.valueOf(i3)));
            VideoReport.reportEvent("clck", view, mapOf);
            Integer num = this$0.source;
            if (num != null && num.intValue() == 2) {
                activity.getIntent().putExtra("isFromAlbum", true);
            } else {
                activity.getIntent().putExtra("isFromAlbum", false);
            }
            activity.setResult(-1, activity.getIntent().putExtra("avatar_result", "test_Path"));
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(AdelieAvatarEditFragment this$0, TextView cropAvatarBtn, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(cropAvatarBtn, "cropAvatarBtn");
        this$0.Zh(cropAvatarBtn, 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(AdelieAvatarEditFragment this$0, TextView cropAvatarBtn, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(cropAvatarBtn, "cropAvatarBtn");
        this$0.Zh(cropAvatarBtn, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final URLDrawable Oh(String url) {
        boolean z16;
        boolean contains$default;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "http", false, 2, (Object) null);
        if (contains$default) {
            return URLDrawable.getDrawable(url, obtain);
        }
        return URLDrawable.getFileDrawable(url, obtain);
    }

    private final AdeliePolarLightBkgView Ph() {
        AdeliePolarLightBkgView adeliePolarLightBkgView;
        if (this.bkgView == null) {
            Context context = getContext();
            if (context != null) {
                adeliePolarLightBkgView = new AdeliePolarLightBkgView(context, null, 0, 6, null);
            } else {
                adeliePolarLightBkgView = null;
            }
            this.bkgView = adeliePolarLightBkgView;
        }
        return this.bkgView;
    }

    private final String Qh() {
        return "\u9884\u89c8\u5f62\u8c61";
    }

    private final void Rh() {
        c cVar = new c(new Integer[]{null, Integer.valueOf(R.drawable.mi_), Integer.valueOf(R.drawable.mia)}, this);
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAdapter(cVar);
        }
    }

    private final void Sh() {
        Map mapOf;
        if (this.source == null) {
            return;
        }
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_image_preview");
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, this.source));
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(AdelieAvatarEditFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.croppedImageData.c(BitmapFactory.decodeFile(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(AdelieAvatarEditFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.croppedImageData.d(BitmapFactory.decodeFile(str));
    }

    private final void Vh() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            Integer valueOf = Integer.valueOf(arguments.getInt("source", 0));
            this.source = valueOf;
            String str2 = null;
            if (valueOf != null && valueOf.intValue() == 3) {
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str = arguments2.getString("avatar_image_url", null);
                } else {
                    str = null;
                }
                this.avatarImageUrl = str;
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    str2 = arguments3.getString("cover_image_url", null);
                }
                this.coverImageUrl = str2;
                return;
            }
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                str2 = arguments4.getString("origin_image_url", null);
            }
            this.originImageUrl = str2;
        }
    }

    private final void Wh(Intent data) {
        List<LocalMediaInfo> e16;
        AlbumResult albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT");
        if (albumResult == null || (e16 = albumResult.e()) == null || e16.isEmpty()) {
            return;
        }
        boolean z16 = false;
        String path = e16.get(0).getPath();
        if (path == null) {
            return;
        }
        if (path.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Context context = getContext();
        if (context != null) {
            ac.f366521a.b(context, path, 2);
        }
        ad.INSTANCE.a().f(null);
        QLog.i("AdelieBaseFragment", 1, "path=" + path);
    }

    private final void Xh() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.k
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarEditFragment.Yh(AdelieAvatarEditFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(AdelieAvatarEditFragment this$0) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            View view = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view != null && (textView2 = (TextView) view.findViewById(R.id.ubk)) != null) {
                textView2.setTextColor(context.getColor(R.color.qui_common_brand_standard));
            }
            View view2 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view2 != null && (textView = (TextView) view2.findViewById(R.id.ubl)) != null) {
                textView.setTextColor(context.getColor(R.color.qui_common_brand_standard));
            }
            TextView textView3 = this$0.changeAvatarBtn;
            if (textView3 != null) {
                textView3.setTextColor(context.getColor(R.color.qui_common_brand_standard));
            }
        }
        TextView textView4 = this$0.changeAvatarBtn;
        if (textView4 != null) {
            textView4.setBackground(this$0.Ih(0.0f, c24.a.a(1)));
        }
    }

    private final void Zh(TextView cropBtn, int cropType) {
        boolean z16;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_PTOTO));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026O\n            )\n        )");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d(cropBtn, cropType));
        } else {
            ai(cropBtn, cropType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(final TextView cropBtn, final int cropType) {
        String str;
        if (getActivity() == null) {
            return;
        }
        final Runnable runnable = new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.l
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarEditFragment.bi(cropBtn, cropType, this);
            }
        };
        if (this.originImageLocalUrl != null) {
            runnable.run();
            return;
        }
        Integer num = this.source;
        if (num != null && num.intValue() == 1) {
            String str2 = this.originImageUrl;
            if (str2 != null) {
                Fh(str2, new Function1<Boolean, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarEditFragment$tryStartCropActivity$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        runnable.run();
                    }
                });
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 3 && (str = this.coverImageUrl) != null) {
            Fh(str, new Function1<Boolean, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarEditFragment$tryStartCropActivity$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(TextView cropBtn, int i3, AdelieAvatarEditFragment this$0) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(cropBtn, "$cropBtn");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("crop_type", Integer.valueOf(i3)));
        VideoReport.reportEvent("clck", cropBtn, mapOf);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            if (i3 == 2) {
                AdelieCroppingUtil.f366635a.o(activity, this$0.originImageLocalUrl);
            } else {
                AdelieCroppingUtil.f366635a.n(activity, this$0.originImageLocalUrl);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092 A[Catch: Exception -> 0x00f6, TryCatch #1 {Exception -> 0x00f6, blocks: (B:3:0x0004, B:5:0x0008, B:16:0x00bf, B:18:0x00c6, B:21:0x00ce, B:24:0x00d7, B:27:0x00e0, B:29:0x00e4, B:30:0x00e7, B:32:0x00eb, B:33:0x00ee, B:35:0x00f2, B:38:0x00cb, B:40:0x0073, B:42:0x0079, B:45:0x0081, B:47:0x0085, B:53:0x0092, B:56:0x007e, B:57:0x0017, B:59:0x001d, B:84:0x0068, B:86:0x0022, B:63:0x0025, B:65:0x0029, B:71:0x0036, B:73:0x003e, B:77:0x004a, B:78:0x0055, B:81:0x0050), top: B:2:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0036 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:63:0x0025, B:65:0x0029, B:71:0x0036, B:73:0x003e, B:77:0x004a, B:78:0x0055, B:81:0x0050), top: B:62:0x0025, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ci() {
        boolean z16;
        boolean contains$default;
        boolean z17;
        URLDrawable Oh;
        try {
            Integer num = this.source;
            if (num == null) {
                QLog.e("AdelieAvatarEditFragment", 1, "source is null!!!, please set SOURCE to intent");
                return;
            }
            boolean z18 = false;
            if (num != null && num.intValue() == 1) {
                TextView textView = this.changeAvatarBtn;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                try {
                    String str = this.originImageUrl;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            return;
                        }
                        Option option = Option.obtain();
                        String str2 = this.originImageUrl;
                        if (str2 != null) {
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "http", false, 2, (Object) null);
                            if (contains$default) {
                                z18 = true;
                            }
                        }
                        if (z18) {
                            option.setUrl(this.originImageUrl);
                        } else {
                            option.setLocalPath(this.originImageUrl);
                        }
                        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                        Intrinsics.checkNotNullExpressionValue(option, "option");
                        qQPicLoader.e(option, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.ugc.i
                            @Override // com.tencent.libra.listener.IPicLoadStateListener
                            public final void onStateChange(LoadState loadState, Option option2) {
                                AdelieAvatarEditFragment.di(AdelieAvatarEditFragment.this, loadState, option2);
                            }
                        });
                        return;
                    }
                    z16 = true;
                    if (!z16) {
                    }
                } catch (Exception e16) {
                    QLog.e("AdelieAvatarEditFragment", 1, "loadImage exception ", e16);
                    return;
                }
            }
            if (num.intValue() == 2) {
                TextView textView2 = this.changeAvatarBtn;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                String str3 = this.originImageUrl;
                if (str3 != null && str3.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        return;
                    }
                    String str4 = this.originImageUrl;
                    this.originImageLocalUrl = str4;
                    QLog.i("AdelieAvatarEditFragment", 1, "cropping originImageUrl " + str4 + " begin");
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            AdelieAvatarEditFragment.fi(AdelieAvatarEditFragment.this);
                        }
                    }, 64, null, false);
                    return;
                }
                z17 = true;
                if (!z17) {
                }
            }
            if (num != null && num.intValue() == 3) {
                TextView textView3 = this.changeAvatarBtn;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                URLDrawable Oh2 = Oh(this.avatarImageUrl);
                if (Oh2 == null || (Oh = Oh(this.coverImageUrl)) == null) {
                    return;
                }
                String str5 = this.coverImageUrl;
                if (str5 != null) {
                    Gh(this, str5, null, 2, null);
                }
                RoundImageView roundImageView = this.avatarImageView;
                if (roundImageView != null) {
                    roundImageView.setImageDrawable(Oh2);
                }
                RoundImageView roundImageView2 = this.fullBodyImageView;
                if (roundImageView2 != null) {
                    roundImageView2.setImageDrawable(Oh);
                }
            }
        } catch (Exception e17) {
            QLog.e("AdelieAvatarEditFragment", 1, "cropping image error = " + e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(final AdelieAvatarEditFragment this$0, LoadState loadState, final Option option) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && option.getResultBitMap() != null) {
            String str = this$0.originImageUrl;
            if (str != null) {
                Gh(this$0, str, null, 2, null);
            }
            QLog.i("AdelieAvatarEditFragment", 1, "cropping originImageUrl " + this$0.originImageUrl);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.c
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarEditFragment.ei(AdelieAvatarEditFragment.this, option);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(final AdelieAvatarEditFragment this$0, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdelieCroppingUtil adelieCroppingUtil = AdelieCroppingUtil.f366635a;
        Bitmap resultBitMap = option.getResultBitMap();
        Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
        this$0.croppedImageData = adelieCroppingUtil.e(resultBitMap);
        com.tencent.qqnt.adelie.homepage.utils.b.f348409a.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarEditFragment$updateImageView$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AdelieCroppingUtil.AdelieCroppedImageData adelieCroppedImageData;
                Bitmap bitmap;
                RoundImageView roundImageView;
                RoundImageView roundImageView2;
                AdelieCroppingUtil.AdelieCroppedImageData adelieCroppedImageData2;
                adelieCroppedImageData = AdelieAvatarEditFragment.this.croppedImageData;
                Bitmap avatar = adelieCroppedImageData.getAvatar();
                if (avatar != null) {
                    bitmap = Bitmap.createScaledBitmap(avatar, 256, 256, true);
                    Intrinsics.checkNotNullExpressionValue(bitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
                } else {
                    bitmap = null;
                }
                roundImageView = AdelieAvatarEditFragment.this.avatarImageView;
                if (roundImageView != null) {
                    roundImageView.setImageBitmap(bitmap);
                }
                roundImageView2 = AdelieAvatarEditFragment.this.fullBodyImageView;
                if (roundImageView2 != null) {
                    adelieCroppedImageData2 = AdelieAvatarEditFragment.this.croppedImageData;
                    roundImageView2.setImageBitmap(adelieCroppedImageData2.getCover());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(final AdelieAvatarEditFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.originImageUrl;
        Intrinsics.checkNotNull(str);
        if (!new File(str).exists()) {
            return;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(this$0.originImageUrl);
        if (decodeFile == null) {
            QLog.e("AdelieAvatarEditFragment", 1, "bitmap " + this$0.originImageUrl + " is null");
            return;
        }
        this$0.croppedImageData = AdelieCroppingUtil.f366635a.e(decodeFile);
        com.tencent.qqnt.adelie.homepage.utils.b.f348409a.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarEditFragment$updateImageView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
            
                r0 = r3.this$0.fullBodyImageView;
             */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
            
                r1 = r3.this$0.avatarImageView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                AdelieCroppingUtil.AdelieCroppedImageData adelieCroppedImageData;
                Bitmap bitmap;
                AdelieCroppingUtil.AdelieCroppedImageData adelieCroppedImageData2;
                RoundImageView roundImageView;
                AdelieCroppingUtil.AdelieCroppedImageData adelieCroppedImageData3;
                RoundImageView roundImageView2;
                adelieCroppedImageData = AdelieAvatarEditFragment.this.croppedImageData;
                Bitmap avatar = adelieCroppedImageData.getAvatar();
                if (avatar != null) {
                    bitmap = Bitmap.createScaledBitmap(avatar, 256, 256, true);
                    Intrinsics.checkNotNullExpressionValue(bitmap, "Bitmap.createScaledBitma\u2026s, width, height, filter)");
                } else {
                    bitmap = null;
                }
                if (bitmap != null && roundImageView2 != null) {
                    roundImageView2.setImageBitmap(bitmap);
                }
                adelieCroppedImageData2 = AdelieAvatarEditFragment.this.croppedImageData;
                if (adelieCroppedImageData2.getCover() == null || roundImageView == null) {
                    return;
                }
                adelieCroppedImageData3 = AdelieAvatarEditFragment.this.croppedImageData;
                roundImageView.setImageBitmap(adelieCroppedImageData3.getCover());
            }
        });
        QLog.i("AdelieAvatarEditFragment", 1, "cropping originImageUrl " + this$0.originImageUrl + " end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int parseColor;
        final TextView textView;
        QUISecNavBar qUISecNavBar;
        super.doOnCreateView(inflater, container, savedInstanceState);
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText(Qh());
            this.quiSecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
            this.quiSecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_allwhite_primary);
        }
        Vh();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            this.avatarImageView = (RoundImageView) view.findViewById(R.id.t0n);
            this.fullBodyImageView = (RoundImageView) view.findViewById(R.id.vgh);
            this.bannerLayout = (BannerLayout) view.findViewById(R.id.t3n);
            com.tencent.robot.adelie.homepage.ugc.view.q.f366599a.a(getContext(), (LinearLayout) view.findViewById(R.id.ahq));
            TextView textView2 = (TextView) view.findViewById(R.id.tr5);
            this.changeAvatarBtn = textView2;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieAvatarEditFragment.Kh(AdelieAvatarEditFragment.this, view2);
                    }
                });
            }
            QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f114706u2);
            this.useBtn = qUIButton;
            if (qUIButton != null) {
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieAvatarEditFragment.Lh(AdelieAvatarEditFragment.this, view2);
                    }
                });
            }
            QUIButton qUIButton2 = this.useBtn;
            if (qUIButton2 != null) {
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, qUIButton2, "em_bas_finish", null, null, null, null, null, 124, null);
            }
            final TextView cropAvatarBtn = (TextView) view.findViewById(R.id.ubk);
            if (cropAvatarBtn != null) {
                cropAvatarBtn.setBackground(Jh(this, 0.0f, 0, 3, null));
            }
            if (cropAvatarBtn != null) {
                cropAvatarBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieAvatarEditFragment.Mh(AdelieAvatarEditFragment.this, cropAvatarBtn, view2);
                    }
                });
            }
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            Intrinsics.checkNotNullExpressionValue(cropAvatarBtn, "cropAvatarBtn");
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, cropAvatarBtn, "em_bas_crop", null, null, null, null, null, 124, null);
            TextView textView3 = (TextView) view.findViewById(R.id.ubl);
            if (textView3 != null) {
                textView3.setBackground(Jh(this, 0.0f, 0, 3, null));
            }
            if (textView3 != null) {
                textView = cropAvatarBtn;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieAvatarEditFragment.Nh(AdelieAvatarEditFragment.this, textView, view2);
                    }
                });
            } else {
                textView = cropAvatarBtn;
            }
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, textView, "em_bas_crop", null, null, null, null, null, 124, null);
            ci();
            Rh();
            AdeliePolarLightBkgView Ph = Ph();
            if (Ph != null) {
                Ph.a();
            }
            if (Ph != null) {
                Ph.setBackgroundVisibility(8);
            }
            this.titleRoot.addView(Ph, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
        Xh();
        if (je0.a.a(BaseApplication.getContext())) {
            parseColor = Color.parseColor("#14181F");
        } else {
            parseColor = Color.parseColor("#CFEAFF");
        }
        this.titleRoot.setBackgroundColor(parseColor);
        AdelieAvatarResult a16 = ad.INSTANCE.a();
        a16.d(null);
        a16.e(null);
        Sh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167574dt1;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        URLDrawable Oh;
        URLDrawable Oh2;
        super.onActivityResult(requestCode, resultCode, data);
        Boolean bool = null;
        final String str = null;
        final String str2 = null;
        boolean z16 = false;
        if (requestCode == 134 && resultCode == -1) {
            if (data != null) {
                str = data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            }
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (z16 || (Oh2 = Oh(str)) == null) {
                return;
            }
            com.tencent.qqnt.adelie.homepage.utils.b.f348409a.e(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarEditFragment.Th(AdelieAvatarEditFragment.this, str);
                }
            });
            RoundImageView roundImageView = this.avatarImageView;
            if (roundImageView != null) {
                roundImageView.setImageDrawable(Oh2);
            }
            this.hasCropAvatar = true;
            return;
        }
        if (requestCode == 135 && resultCode == -1) {
            if (data != null) {
                str2 = data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            }
            if (str2 == null || str2.length() == 0) {
                z16 = true;
            }
            if (z16 || (Oh = Oh(str2)) == null) {
                return;
            }
            com.tencent.qqnt.adelie.homepage.utils.b.f348409a.e(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieAvatarEditFragment.Uh(AdelieAvatarEditFragment.this, str2);
                }
            });
            RoundImageView roundImageView2 = this.fullBodyImageView;
            if (roundImageView2 != null) {
                roundImageView2.setImageDrawable(Oh);
            }
            this.hasCropCover = true;
            return;
        }
        if (requestCode == 133 && resultCode == -1) {
            if (data != null) {
                bool = Boolean.valueOf(data.getBooleanExtra("isFromAlbum", false));
            }
            Intent intent = new Intent(data);
            Integer num = this.source;
            if ((num == null || num.intValue() != 2) && !Intrinsics.areEqual(bool, Boolean.TRUE)) {
                intent.putExtra("isFromAlbum", false);
            } else {
                intent.putExtra("isFromAlbum", true);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        if (requestCode == 100001 && resultCode == -1) {
            Intent intent2 = new Intent(data);
            intent2.putExtra("isFromAlbum", true);
            Wh(intent2);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AdeliePolarLightBkgView adeliePolarLightBkgView = this.bkgView;
        if (adeliePolarLightBkgView != null) {
            adeliePolarLightBkgView.b();
        }
        this.bkgView = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgOut(view);
        }
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAutoScroll(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgIn(view, false);
        }
        BannerLayout bannerLayout = this.bannerLayout;
        if (bannerLayout != null) {
            bannerLayout.setAutoScroll(true);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AdelieCroppingUtil.f366635a.h(activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
