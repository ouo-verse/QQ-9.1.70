package com.tencent.mobileqq.wink.magicstudio.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001FB7\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010/\u001a\n ,*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010A\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton;", "Landroid/widget/FrameLayout;", "", "p", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonInfo", BdhLogUtil.LogTag.Tag_Conn, "", "disable", DomainData.DOMAIN_NAME, "v", "show", "w", "", "msg", "", "iconType", HippyTKDListViewAdapter.X, "u", "t", "result", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton$a;", "o", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "e", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "f", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "vm", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", tl.h.F, "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioViewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "i", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "saveBtn", "D", "Landroid/widget/FrameLayout;", "saveLoadingContainer", "Landroid/view/View;", "E", "Landroid/view/View;", "loadingView", UserInfo.SEX_FEMALE, "Z", "initSaveState", "G", "saveBtnDisable", "H", "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton$a;", "saveInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;Lcom/tencent/mobileqq/qqpermission/QQPermission;)V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioSaveButton extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView saveBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout saveLoadingContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean initSaveState;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean saveBtnDisable;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MagicSaveInfo saveInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioMultiViewModel vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioViewModel magicStudioViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQPermission qqPermission;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "d", "(I)V", "haveSaved", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "residueDownloadNum", "c", "f", RemoteProxy.KEY_RESULT_TYPE, "<init>", "(ILjava/lang/String;I)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class MagicSaveInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int haveSaved;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String residueDownloadNum;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int resultType;

        public MagicSaveInfo() {
            this(0, null, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getHaveSaved() {
            return this.haveSaved;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getResidueDownloadNum() {
            return this.residueDownloadNum;
        }

        /* renamed from: c, reason: from getter */
        public final int getResultType() {
            return this.resultType;
        }

        public final void d(int i3) {
            this.haveSaved = i3;
        }

        public final void e(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.residueDownloadNum = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MagicSaveInfo)) {
                return false;
            }
            MagicSaveInfo magicSaveInfo = (MagicSaveInfo) other;
            if (this.haveSaved == magicSaveInfo.haveSaved && Intrinsics.areEqual(this.residueDownloadNum, magicSaveInfo.residueDownloadNum) && this.resultType == magicSaveInfo.resultType) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.resultType = i3;
        }

        public int hashCode() {
            return (((this.haveSaved * 31) + this.residueDownloadNum.hashCode()) * 31) + this.resultType;
        }

        @NotNull
        public String toString() {
            return "MagicSaveInfo(haveSaved=" + this.haveSaved + ", residueDownloadNum=" + this.residueDownloadNum + ", resultType=" + this.resultType + ")";
        }

        public MagicSaveInfo(int i3, @NotNull String residueDownloadNum, int i16) {
            Intrinsics.checkNotNullParameter(residueDownloadNum, "residueDownloadNum");
            this.haveSaved = i3;
            this.residueDownloadNum = residueDownloadNum;
            this.resultType = i16;
        }

        public /* synthetic */ MagicSaveInfo(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "-1" : str, (i17 & 4) != 0 ? 0 : i16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioSaveButton(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull LifecycleCoroutineScope lifecycleScope, @NotNull MagicStudioMultiViewModel vm5, @NotNull MagicStudioViewModel magicStudioViewModel, @NotNull QQPermission qqPermission) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(magicStudioViewModel, "magicStudioViewModel");
        Intrinsics.checkNotNullParameter(qqPermission, "qqPermission");
        this.lifecycleOwner = lifecycleOwner;
        this.lifecycleScope = lifecycleScope;
        this.vm = vm5;
        this.magicStudioViewModel = magicStudioViewModel;
        this.qqPermission = qqPermission;
        this.TAG = MagicStudioSaveButton.class.getSimpleName();
        this.saveInfo = new MagicSaveInfo(0, null, 0, 7, null);
        p();
    }

    public static /* synthetic */ void B(MagicStudioSaveButton magicStudioSaveButton, boolean z16, MagicStudioButtonInfo magicStudioButtonInfo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            magicStudioButtonInfo = null;
        }
        magicStudioSaveButton.A(z16, magicStudioButtonInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(MagicStudioButtonInfo buttonInfo) {
        boolean z16;
        if (!this.initSaveState) {
            this.initSaveState = true;
            ImageView imageView = this.saveBtn;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            MagicSaveInfo magicSaveInfo = this.saveInfo;
            String subtitleString = buttonInfo.getSubtitleString();
            if (subtitleString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                subtitleString = "-1";
            }
            magicSaveInfo.e(subtitleString);
            if (buttonInfo.getActionType() == 4) {
                this.saveBtnDisable = true;
                n(true);
            }
            w(false);
            return;
        }
        A(true, buttonInfo);
    }

    private final void n(boolean disable) {
        if (disable) {
            ImageView imageView = this.saveBtn;
            if (imageView != null) {
                imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.qui_download, R.drawable.qui_download_icon_secondary_01));
                return;
            }
            return;
        }
        ImageView imageView2 = this.saveBtn;
        if (imageView2 != null) {
            imageView2.setImageResource(TokenResUtils.getTokenRes(R.drawable.qui_download, R.drawable.qui_download_selector));
        }
    }

    private final void p() {
        LayoutInflater.from(getContext()).inflate(R.layout.dtu, this);
        this.saveBtn = (ImageView) findViewById(R.id.ifr);
        this.saveLoadingContainer = (FrameLayout) findViewById(R.id.f793949n);
        ImageView imageView = this.saveBtn;
        if (imageView != null) {
            imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.qui_download, R.drawable.qui_download_selector));
        }
        ImageView imageView2 = this.saveBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MagicStudioSaveButton.q(MagicStudioSaveButton.this, view);
                }
            });
        }
        ImageView imageView3 = this.saveBtn;
        if (imageView3 != null) {
            imageView3.setContentDescription("\u4e0b\u8f7d");
        }
        this.vm.T1().observe(this.lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.view.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicStudioSaveButton.r(MagicStudioSaveButton.this, (List) obj);
            }
        });
        this.lifecycleScope.launchWhenResumed(new MagicStudioSaveButton$initView$3(this, null));
        this.vm.d2().observe(this.lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.view.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MagicStudioSaveButton.s(MagicStudioSaveButton.this, (Boolean) obj);
            }
        });
        this.lifecycleScope.launchWhenResumed(new MagicStudioSaveButton$initView$5(this, null));
        this.vm.n2(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MagicStudioSaveButton this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MagicStudioSaveButton this$0, List it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        List list = it;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                if (((GenerateInfo) it5.next()).getIsSelected()) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (!z16 && !this$0.saveBtnDisable) {
            this$0.n(false);
        } else {
            this$0.n(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MagicStudioSaveButton this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool == null) {
            w53.b.g(this$0.TAG, "saveImageResult is null");
        } else if (!bool.booleanValue()) {
            w53.b.c(this$0.TAG, "saveImageResult is false");
            B(this$0, false, null, 2, null);
        } else {
            w53.b.f(this$0.TAG, "save image success");
            this$0.magicStudioViewModel.T1(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        int i3;
        ArrayList<GenerateInfo> c16;
        m83.b bVar = m83.b.f416442a;
        ImageView imageView = this.saveBtn;
        String residueDownloadNum = this.saveInfo.getResidueDownloadNum();
        List<GenerateInfo> value = this.vm.T1().getValue();
        int i16 = 0;
        if (value != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        JumpInfo a26 = this.vm.a2();
        if (a26 != null && (c16 = a26.c()) != null) {
            i16 = c16.size();
        }
        bVar.v(imageView, residueDownloadNum, i3, i16, this.vm.getMaterialId());
    }

    private final void u() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RESIDUE_DOWNLOAD_NUM, this.saveInfo.getResidueDownloadNum());
        buildElementParams.put("result_type", Integer.valueOf(this.saveInfo.getResultType()));
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_QZ_SAVE_RESULT, null, buildElementParams);
    }

    private final void v() {
        if (this.saveBtnDisable) {
            t();
            this.saveInfo.d(1);
            this.saveInfo.f(3);
            u();
            y(this, "\u6b21\u6570\u5df2\u7528\u5c3d\uff0c\u53d1\u8868\u540e\u518d\u4fdd\u5b58\u5427", 0, 2, null);
            return;
        }
        WinkMagicStudioLogicUtils.f323883a.d(this.qqPermission, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton$saveImages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                MagicStudioMultiViewModel magicStudioMultiViewModel;
                String str;
                MagicStudioSaveButton.MagicSaveInfo magicSaveInfo;
                MagicStudioMultiViewModel magicStudioMultiViewModel2;
                String str2;
                if (!z16) {
                    str2 = MagicStudioSaveButton.this.TAG;
                    w53.b.f(str2, "no storage permission");
                    return;
                }
                magicStudioMultiViewModel = MagicStudioSaveButton.this.vm;
                JumpInfo a26 = magicStudioMultiViewModel.a2();
                if (a26 == null || a26.c().size() <= 0) {
                    str = MagicStudioSaveButton.this.TAG;
                    w53.b.f(str, "saveBtn but jump == null");
                    MagicStudioSaveButton.this.x("\u81f3\u5c11\u9009\u62e9\u4e00\u5f20\u56fe\u7247", 1);
                } else {
                    magicSaveInfo = MagicStudioSaveButton.this.saveInfo;
                    magicSaveInfo.d(1);
                    MagicStudioSaveButton.this.w(true);
                    MagicStudioSaveButton.this.t();
                    magicStudioMultiViewModel2 = MagicStudioSaveButton.this.vm;
                    magicStudioMultiViewModel2.p2(a26.c());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(boolean show) {
        int i3;
        ArrayList<GenerateInfo> c16;
        FrameLayout frameLayout;
        if (this.loadingView == null) {
            View loadingView = LoadingUtil.getLoadingView(getContext(), ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f), 2);
            this.loadingView = loadingView;
            if (loadingView != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f));
                layoutParams.addRule(13);
                loadingView.setLayoutParams(layoutParams);
            }
        }
        if (show) {
            ImageView imageView = this.saveBtn;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            View view = this.loadingView;
            if (view != null) {
                FrameLayout frameLayout2 = this.saveLoadingContainer;
                if (frameLayout2 != null) {
                    frameLayout2.removeView(view);
                }
                FrameLayout frameLayout3 = this.saveLoadingContainer;
                if (frameLayout3 != null) {
                    frameLayout3.addView(view);
                    return;
                }
                return;
            }
            return;
        }
        ImageView imageView2 = this.saveBtn;
        int i16 = 0;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        View view2 = this.loadingView;
        if (view2 != null && (frameLayout = this.saveLoadingContainer) != null) {
            frameLayout.removeView(view2);
        }
        m83.b bVar = m83.b.f416442a;
        ImageView imageView3 = this.saveBtn;
        String residueDownloadNum = this.saveInfo.getResidueDownloadNum();
        List<GenerateInfo> value = this.vm.T1().getValue();
        if (value != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        JumpInfo a26 = this.vm.a2();
        if (a26 != null && (c16 = a26.c()) != null) {
            i16 = c16.size();
        }
        bVar.w(imageView3, residueDownloadNum, i3, i16, this.vm.getMaterialId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(final String msg2, final int iconType) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.view.n
            @Override // java.lang.Runnable
            public final void run() {
                MagicStudioSaveButton.z(iconType, msg2);
            }
        });
    }

    static /* synthetic */ void y(MagicStudioSaveButton magicStudioSaveButton, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        magicStudioSaveButton.x(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(MobileQQ.sMobileQQ, i3, msg2, 0).show();
    }

    public final void A(boolean result, @Nullable MagicStudioButtonInfo buttonInfo) {
        String str;
        String str2;
        String str3;
        boolean z16;
        MagicSaveInfo magicSaveInfo = this.saveInfo;
        if (buttonInfo == null || (str = buttonInfo.getSubtitleString()) == null) {
            str = "-1";
        }
        magicSaveInfo.e(str);
        boolean z17 = false;
        if (buttonInfo != null) {
            if (buttonInfo.getActionType() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.saveBtnDisable = z16;
            n(z16);
        }
        w(false);
        if (result) {
            String str4 = null;
            if (buttonInfo != null) {
                str2 = buttonInfo.getSubtitleString();
            } else {
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                z17 = true;
            }
            if (z17) {
                str3 = "\u5df2\u4fdd\u5b58\u5230\u672c\u5730";
            } else {
                if (buttonInfo != null) {
                    str4 = buttonInfo.getSubtitleString();
                }
                str3 = "\u5df2\u4fdd\u5b58\u5230\u672c\u5730, " + str4;
            }
            this.saveInfo.f(1);
            x(str3, 2);
        } else {
            this.saveInfo.f(2);
            x("\u4fdd\u5b58\u5931\u8d25", 1);
        }
        u();
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final MagicSaveInfo getSaveInfo() {
        return this.saveInfo;
    }
}
