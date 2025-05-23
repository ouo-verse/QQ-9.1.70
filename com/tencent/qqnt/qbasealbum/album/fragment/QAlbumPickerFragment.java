package com.tencent.qqnt.qbasealbum.album.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qbasealbum.WinkHomeActivity;
import com.tencent.qqnt.qbasealbum.album.view.PickerBottomBarPart;
import com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerFactory;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.performance.QAlbumPerformanceHelper;
import com.tencent.qqnt.qbasealbum.report.b;
import com.tencent.qqnt.qbasealbum.report.c;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020\fH\u0016R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/fragment/QAlbumPickerFragment;", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment;", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerFactory;", "Xh", "Wh", "", "getContentLayoutId", "", "getLogTag", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "u3", "", "duration", "onPageOut", DKHippyEvent.EVENT_STOP, "", "isFromQZoneMedia", "Kh", "Mh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Req, "Z", "isFromSave", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "contentView", "T", "J", "pageInTime", "<init>", "()V", "U", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class QAlbumPickerFragment extends QAlbumBaseMainFragment<PickerInitBean> {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isFromSave;

    /* renamed from: S, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: T, reason: from kotlin metadata */
    private long pageInTime;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/fragment/QAlbumPickerFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "initBean", "Landroid/content/Intent;", "b", "Lcom/tencent/qqnt/qbasealbum/model/Config;", DownloadInfo.spKey_Config, "pickerInitBean", "Lcom/tencent/qqnt/qbasealbum/album/fragment/QAlbumPickerFragment;", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final QAlbumPickerFragment a(@Nullable Config config, @Nullable PickerInitBean pickerInitBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QAlbumPickerFragment) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config, (Object) pickerInitBean);
            }
            QAlbumPickerFragment qAlbumPickerFragment = new QAlbumPickerFragment();
            qAlbumPickerFragment.setArguments(qAlbumPickerFragment.wh(config, pickerInitBean));
            return qAlbumPickerFragment;
        }

        @NotNull
        public final Intent b(@NotNull Context context, @NotNull PickerInitBean initBean) {
            FragmentActivity fragmentActivity;
            Intent intent;
            Bundle extras;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) initBean);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Intent intent2 = new Intent(context, (Class<?>) WinkHomeActivity.class);
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null && (intent = fragmentActivity.getIntent()) != null && (extras = intent.getExtras()) != null) {
                intent2.putExtras(extras);
            }
            intent2.putExtra("public_fragment_class", QAlbumPickerFragment.class.getName());
            intent2.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            intent2.putExtra("ARG_PICKER_INIT_BEAN", initBean);
            return intent2;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/qbasealbum/album/fragment/QAlbumPickerFragment$b", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends OnBackPressedCallback {
        static IPatchRedirector $redirector_;

        b() {
            super(true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QAlbumPickerFragment.this);
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QAlbumPickerFragment.this.onBackEvent();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QAlbumPickerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment
    public void Kh(boolean isFromQZoneMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isFromQZoneMedia);
            return;
        }
        Intent intent = new Intent();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(Hh().getSelectedMedia()));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "this@QAlbumPickerFragment.requireActivity()");
        albumResult.m(com.tencent.qqnt.qbasealbum.album.b.h(requireActivity).O1());
        Unit unit = Unit.INSTANCE;
        Intent putExtra = intent.putExtra("ALBUM_RESULT", albumResult);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(AlbumR\u2026isQualityRaw()\n        })");
        requireActivity().setResult(-1, putExtra);
        requireActivity().finish();
        requireActivity().overridePendingTransition(0, R.anim.f154816sj);
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment
    public void Mh(boolean isFromQZoneMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, isFromQZoneMedia);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment
    @NotNull
    /* renamed from: Wh, reason: merged with bridge method [inline-methods] */
    public PickerInitBean Dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PickerInitBean) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        PickerInitBean.Companion companion = PickerInitBean.INSTANCE;
        return new PickerInitBean.a().a();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment
    @NotNull
    /* renamed from: Xh, reason: merged with bridge method [inline-methods] */
    public PickerFactory Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PickerFactory) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new PickerFactory(Eh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f168439ft3;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    protected String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QAlbumPickerFragment";
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new b());
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) savedInstanceState);
            return;
        }
        QAlbumPerformanceHelper.Companion companion = QAlbumPerformanceHelper.INSTANCE;
        companion.a().k(PageType.LOCAL_ALL.ordinal(), Ih());
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isFromSave = z16;
        companion.a().f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view = (View) iPatchRedirector.redirect((short) 8, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            Intrinsics.checkNotNull(onCreateView);
            this.contentView = onCreateView;
            c cVar = c.f361503a;
            if (onCreateView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                onCreateView = null;
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qq_ref_pgid", "pg_aio"), TuplesKt.to("graph_selector_source", 2));
            cVar.f(onCreateView, "pg_bas_album_selector", mutableMapOf);
            view = this.contentView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onDestroy();
        QAlbumPerformanceHelper.INSTANCE.a().g(getTAG());
        for (LocalMediaInfo localMediaInfo : Hh().getSelectedMedia()) {
            localMediaInfo.setSelectStatus(2);
            com.tencent.qqnt.qbasealbum.ktx.b.s(localMediaInfo, 0);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void onPageOut(long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, duration);
            return;
        }
        if (duration == 0) {
            if (this.pageInTime == 0) {
                return;
            } else {
                duration = System.currentTimeMillis() - this.pageInTime;
            }
        }
        PickerTitleBarPart pickerTitleBarPart = (PickerTitleBarPart) com.tencent.qqnt.qbasealbum.ktx.a.a(this, PickerTitleBarPart.class);
        if (pickerTitleBarPart != null) {
            pickerTitleBarPart.onPageOut(duration);
        }
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        VideoReport.reportPgOut(view);
        this.pageInTime = 0L;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onPause();
        QAlbumPerformanceHelper.INSTANCE.a().h();
        ApngImage.pauseAll();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment, com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        u3();
        QAlbumPerformanceHelper a16 = QAlbumPerformanceHelper.INSTANCE.a();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        a16.i(requireContext);
        ApngImage.resumeAll();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onStop();
            b.a.a(this, 0L, 1, null);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment, com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LiveData<com.tencent.qqnt.qbasealbum.datahub.a> V = LocalMediaDataHub.INSTANCE.a().V();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.datahub.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QAlbumPickerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.datahub.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.datahub.a it) {
                PickerLocalMediaViewModel Fh;
                SelectedMediaViewModel Hh;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Fh = QAlbumPickerFragment.this.Fh();
                if (Fh != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Hh = QAlbumPickerFragment.this.Hh();
                    Fh.v2(it, Hh);
                }
            }
        };
        V.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QAlbumPickerFragment.Yh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.qbasealbum.report.b
    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.pageInTime = System.currentTimeMillis();
        PickerTitleBarPart pickerTitleBarPart = (PickerTitleBarPart) com.tencent.qqnt.qbasealbum.ktx.a.a(this, PickerTitleBarPart.class);
        if (pickerTitleBarPart != null) {
            pickerTitleBarPart.u3();
        }
        PickerBottomBarPart pickerBottomBarPart = (PickerBottomBarPart) com.tencent.qqnt.qbasealbum.ktx.a.a(this, PickerBottomBarPart.class);
        if (pickerBottomBarPart != null) {
            pickerBottomBarPart.u3();
        }
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        VideoReport.reportPgIn(view);
    }
}
