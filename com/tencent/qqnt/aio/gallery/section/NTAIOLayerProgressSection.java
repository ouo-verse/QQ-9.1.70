package com.tencent.qqnt.aio.gallery.section;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.gallery.i;
import com.tencent.qqnt.aio.gallery.progress.FakeProgressSeekBar;
import com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.IVideoOfflineDownload;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0003HIJB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eJ(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J \u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R!\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0007088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R!\u0010@\u001a\b\u0012\u0004\u0012\u00020>088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b?\u0010<R\u001d\u0010D\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010:\u001a\u0004\bB\u0010C\u00a8\u0006K"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Landroid/view/View$OnClickListener;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "", "y", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "downloadState", "G", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "data", "", "position", "", "", "payload", "onBindData", "", NodeProps.VISIBLE, HippyTKDListViewAdapter.X, "v", NodeProps.ON_CLICK, "Landroid/widget/SeekBar;", "seekBar", "progress", "fromUser", "onProgressChanged", "onStartTrackingTouch", "onStopTrackingTouch", "d", "Landroid/view/View;", "mProgressRootView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mCancelBtn", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mProgressDes", "Lcom/tencent/qqnt/aio/gallery/progress/FakeProgressSeekBar;", h.F, "Lcom/tencent/qqnt/aio/gallery/progress/FakeProgressSeekBar;", "mProgressBar", "i", "J", "mFileSize", "Landroidx/lifecycle/Observer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "B", "()Landroidx/lifecycle/Observer;", "mFileDownloadLoadStateObserver", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", BdhLogUtil.LogTag.Tag_Conn, "mObserver", "Lev3/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lev3/a;", "mBottomControlLayout", "<init>", "()V", "E", "a", "b", "c", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NTAIOLayerProgressSection extends Section<RFWLayerItemMediaInfo> implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBottomControlLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mProgressRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mCancelBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mProgressDes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FakeProgressSeekBar mProgressBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mFileSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFileDownloadLoadStateObserver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection$a;", "", "", "FAKE_STEP", "I", "FAKE_UPDATE_DELAY", "NORMAL_STEP", "NORMAL_UPDATE_DELAY", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection$b;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "downloadState", "", "a", "<init>", "(Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection;)V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class b implements Observer<RFWLayerFileDownloadState> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAIOLayerProgressSection.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerFileDownloadState downloadState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadState);
                return;
            }
            Intrinsics.checkNotNullParameter(downloadState, "downloadState");
            if (!Intrinsics.areEqual(downloadState.getMediaId(), ((RFWLayerItemMediaInfo) ((Section) NTAIOLayerProgressSection.this).mData).getMediaId())) {
                return;
            }
            RFWLayerFileDownloadState.FileState fileState = downloadState.getFileState();
            RFWLayerFileDownloadState.FileState fileState2 = RFWLayerFileDownloadState.FileState.DOWNLOADING;
            if (fileState == fileState2 && !i.f350003a.c().containsKey(downloadState.getMediaId())) {
                return;
            }
            if (!((RFWLayerItemMediaInfo) ((Section) NTAIOLayerProgressSection.this).mData).isVideo() && !((RFWLayerItemMediaInfo) ((Section) NTAIOLayerProgressSection.this).mData).isShowOriginPic()) {
                return;
            }
            if (downloadState.getFileState() == fileState2) {
                if (NTAIOLayerProgressSection.this.mProgressBar != null) {
                    int progressPercent = (int) (downloadState.getProgressPercent() * 100);
                    FakeProgressSeekBar fakeProgressSeekBar = NTAIOLayerProgressSection.this.mProgressBar;
                    Intrinsics.checkNotNull(fakeProgressSeekBar);
                    if (progressPercent >= fakeProgressSeekBar.getProgress()) {
                        NTAIOLayerProgressSection.this.G(downloadState);
                        return;
                    }
                    return;
                }
                return;
            }
            if (downloadState.getFileState() == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                NTAIOLayerProgressSection.this.y();
            } else {
                NTAIOLayerProgressSection.this.x(false);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection$c;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "layerPicLoadState", "", "a", "<init>", "(Lcom/tencent/qqnt/aio/gallery/section/NTAIOLayerProgressSection;)V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class c implements Observer<RFWLayerPicLoadState> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAIOLayerProgressSection.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerPicLoadState layerPicLoadState) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) layerPicLoadState);
                return;
            }
            Intrinsics.checkNotNullParameter(layerPicLoadState, "layerPicLoadState");
            String picId = layerPicLoadState.getPicId();
            RFWLayerPicInfo layerPicInfo = ((RFWLayerItemMediaInfo) ((Section) NTAIOLayerProgressSection.this).mData).getLayerPicInfo();
            if (layerPicInfo != null) {
                str = layerPicInfo.getPicId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(picId, str) && ((RFWLayerItemMediaInfo) ((Section) NTAIOLayerProgressSection.this).mData).isShowOriginPic() && layerPicLoadState.getPicLoadState() == LoadState.STATE_DOWNLOADING) {
                RFWLog.i(NTAIOLayerProgressSection.this.getTAG(), RFWLog.USR, layerPicLoadState.getPicId() + " state:" + layerPicLoadState);
                NTAIOLayerProgressSection.this.x(true);
                FakeProgressSeekBar fakeProgressSeekBar = NTAIOLayerProgressSection.this.mProgressBar;
                if (fakeProgressSeekBar != null) {
                    fakeProgressSeekBar.setProgress(0);
                }
                FakeProgressSeekBar fakeProgressSeekBar2 = NTAIOLayerProgressSection.this.mProgressBar;
                if (fakeProgressSeekBar2 != null) {
                    fakeProgressSeekBar2.setVisibility(0);
                }
                FakeProgressSeekBar fakeProgressSeekBar3 = NTAIOLayerProgressSection.this.mProgressBar;
                if (fakeProgressSeekBar3 != null) {
                    fakeProgressSeekBar3.setTargetProgress(90, 16, 1);
                }
                TextView textView = NTAIOLayerProgressSection.this.mProgressDes;
                if (textView != null) {
                    textView.setText("\u4e0b\u8f7d\u4e2d");
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTAIOLayerProgressSection() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection$mFileDownloadLoadStateObserver$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTAIOLayerProgressSection.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final NTAIOLayerProgressSection.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new NTAIOLayerProgressSection.b() : (NTAIOLayerProgressSection.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mFileDownloadLoadStateObserver = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection$mObserver$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTAIOLayerProgressSection.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final NTAIOLayerProgressSection.c invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new NTAIOLayerProgressSection.c() : (NTAIOLayerProgressSection.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mObserver = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ev3.a>() { // from class: com.tencent.qqnt.aio.gallery.section.NTAIOLayerProgressSection$mBottomControlLayout$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTAIOLayerProgressSection.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ev3.a invoke() {
                    View view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ev3.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
                    view = ((Section) NTAIOLayerProgressSection.this).mRootView;
                    return (ev3.a) g16.getIocInterface(ev3.a.class, view, null);
                }
            });
            this.mBottomControlLayout = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final ev3.a A() {
        return (ev3.a) this.mBottomControlLayout.getValue();
    }

    private final Observer<RFWLayerFileDownloadState> B() {
        return (Observer) this.mFileDownloadLoadStateObserver.getValue();
    }

    private final Observer<RFWLayerPicLoadState> C() {
        return (Observer) this.mObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(NTAIOLayerProgressSection this$0, IVideoOfflineDownload iVideoOfflineDownload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iVideoOfflineDownload != null) {
            iVideoOfflineDownload.stopVideoOfflineDownload(((RFWLayerItemMediaInfo) this$0.mData).getMediaId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(RFWLayerFileDownloadState downloadState) {
        View view = this.mProgressRootView;
        if (view != null) {
            view.setVisibility(0);
        }
        this.mFileSize = downloadState.getFileSize();
        FakeProgressSeekBar fakeProgressSeekBar = this.mProgressBar;
        if (fakeProgressSeekBar != null) {
            fakeProgressSeekBar.setTargetProgress((int) (downloadState.getProgressPercent() * 100), 16, 5);
        }
        TextView textView = this.mProgressDes;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        FakeProgressSeekBar fakeProgressSeekBar = this.mProgressBar;
        if (fakeProgressSeekBar != null) {
            if (fakeProgressSeekBar.getProgress() != fakeProgressSeekBar.getMax()) {
                x(true);
                FakeProgressSeekBar fakeProgressSeekBar2 = this.mProgressBar;
                if (fakeProgressSeekBar2 != null) {
                    fakeProgressSeekBar2.setTargetProgress(100, 16, 5);
                }
                TextView textView = this.mProgressDes;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            x(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long z() {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        if (((RFWLayerItemMediaInfo) this.mData).isVideo()) {
            return this.mFileSize;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) this.mData;
        if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (originPicInfo = layerPicInfo.getOriginPicInfo()) != null) {
            return originPicInfo.getSize();
        }
        return 0L;
    }

    public final void D(@NotNull View rootView) {
        ImageView imageView;
        TextView textView;
        FakeProgressSeekBar fakeProgressSeekBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mProgressRootView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f168349fq1, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(110.0f));
        layoutParams.gravity = 80;
        ViewGroup viewGroup = (ViewGroup) rootView;
        viewGroup.addView(this.mProgressRootView, layoutParams);
        com.tencent.mobileqq.qui.b.f276860a.a(this.mProgressRootView, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE, RFWNavigationBarImmersiveHelper.ImmersiveType.SIDES);
        View view = this.mProgressRootView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mProgressRootView;
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.az_);
        } else {
            imageView = null;
        }
        this.mCancelBtn = imageView;
        View view3 = this.mProgressRootView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.g27);
        } else {
            textView = null;
        }
        this.mProgressDes = textView;
        View view4 = this.mProgressRootView;
        if (view4 != null) {
            fakeProgressSeekBar = (FakeProgressSeekBar) view4.findViewById(R.id.ilm);
        } else {
            fakeProgressSeekBar = null;
        }
        this.mProgressBar = fakeProgressSeekBar;
        if (fakeProgressSeekBar != null) {
            fakeProgressSeekBar.setEnabled(false);
        }
        FakeProgressSeekBar fakeProgressSeekBar2 = this.mProgressBar;
        if (fakeProgressSeekBar2 != null) {
            fakeProgressSeekBar2.setOnSeekBarChangeListener(this);
        }
        ImageView imageView2 = this.mCancelBtn;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.tencent.qqnt.aio.gallery.b.f349994a.b(ResourcesCompat.getDrawable(viewGroup.getResources(), R.drawable.qui_close_filled, null), ResourcesCompat.getColor(viewGroup.getResources(), R.color.qui_common_feedback_error, null)));
        }
        ImageView imageView3 = this.mCancelBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.az_) {
                Activity activity = null;
                if (((RFWLayerItemMediaInfo) this.mData).isVideo()) {
                    IocPromise ioc = RFWIocAbilityProvider.g().getIoc(IVideoOfflineDownload.class);
                    Context context = v3.getContext();
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                    ioc.withGlobal(activity).done(new OnPromiseResolved() { // from class: com.tencent.qqnt.aio.gallery.section.c
                        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                        public final void onDone(Object obj) {
                            NTAIOLayerProgressSection.F(NTAIOLayerProgressSection.this, (IVideoOfflineDownload) obj);
                        }
                    }).run();
                    x(false);
                } else {
                    Context context2 = v3.getContext();
                    if (context2 instanceof Activity) {
                        activity = (Activity) context2;
                    }
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
        } else {
            Intrinsics.checkNotNullParameter(containerView, "containerView");
            D(containerView);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, seekBar, Integer.valueOf(progress), Boolean.valueOf(fromUser));
            return;
        }
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (progress == seekBar.getMax()) {
            x(false);
            return;
        }
        if (z() != 0) {
            String str = "\u4e0b\u8f7d\u4e2d " + ao.a((((float) (z() * progress)) * 1.0f) / seekBar.getMax()) + "/" + ao.a(z());
            TextView textView = this.mProgressDes;
            if (textView != null) {
                textView.setText(str);
                return;
            }
            return;
        }
        TextView textView2 = this.mProgressDes;
        if (textView2 != null) {
            textView2.setText("\u4e0b\u8f7d\u4e2d");
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) seekBar);
        } else {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) seekBar);
        } else {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    public final void x(boolean visible) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, visible);
            return;
        }
        View view = this.mProgressRootView;
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        ev3.a A = A();
        if (A != null) {
            A.d7(!visible);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(@NotNull RFWLayerItemMediaInfo data, int position, @Nullable List<Object> payload) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, data, Integer.valueOf(position), payload);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (((RFWLayerItemMediaInfo) this.mData).isVideo() || !((RFWLayerItemMediaInfo) this.mData).isShowOriginPic() || TextUtils.isEmpty(((RFWLayerItemMediaInfo) this.mData).getExistSaveOrEditPath())) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerFileDownloadState.class, data.getMediaId(), B());
        }
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        if (layerPicInfo == null || (str = layerPicInfo.getPicId()) == null) {
            str = "";
        }
        RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, str, C());
    }
}
