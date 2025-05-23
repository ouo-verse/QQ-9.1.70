package com.tencent.mobileqq.richmedia.section;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richmedia.depend.c;
import com.tencent.mobileqq.richmedia.depend.d;
import com.tencent.mobileqq.richmedia.e;
import com.tencent.mobileqq.richmedia.section.CommonLayerProgressSection;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.gallery.b;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/richmedia/section/CommonLayerProgressSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "downloadState", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "onBindData", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "mProgressRootView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mCancelBtn", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mProgressDes", "Landroid/widget/SeekBar;", h.F, "Landroid/widget/SeekBar;", "mProgressBar", "Landroidx/lifecycle/Observer;", "i", "Lkotlin/Lazy;", "t", "()Landroidx/lifecycle/Observer;", "mFileDownloadLoadStateObserver", "<init>", "()V", "a", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class CommonLayerProgressSection extends Section<RFWLayerItemMediaInfo> implements View.OnClickListener {

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
    private SeekBar mProgressBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFileDownloadLoadStateObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/richmedia/section/CommonLayerProgressSection$a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "downloadState", "", "a", "<init>", "(Lcom/tencent/mobileqq/richmedia/section/CommonLayerProgressSection;)V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class a implements Observer<RFWLayerFileDownloadState> {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.richmedia.section.CommonLayerProgressSection$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public /* synthetic */ class C8519a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f281746a;

            static {
                int[] iArr = new int[RFWLayerFileDownloadState.FileState.values().length];
                try {
                    iArr[RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RFWLayerFileDownloadState.FileState.DOWNLOADING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f281746a = iArr;
            }
        }

        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerFileDownloadState downloadState) {
            int i3;
            Intrinsics.checkNotNullParameter(downloadState, "downloadState");
            if (Intrinsics.areEqual(downloadState.getMediaId(), ((RFWLayerItemMediaInfo) ((Section) CommonLayerProgressSection.this).mData).getMediaId()) && CommonLayerProgressSection.this.mProgressBar != null) {
                e eVar = e.f281568a;
                if (!eVar.e().containsKey(downloadState.getMediaId())) {
                    return;
                }
                RFWLayerFileDownloadState.FileState fileState = downloadState.getFileState();
                if (fileState == null) {
                    i3 = -1;
                } else {
                    i3 = C8519a.f281746a[fileState.ordinal()];
                }
                if (i3 == 1) {
                    SeekBar seekBar = CommonLayerProgressSection.this.mProgressBar;
                    Intrinsics.checkNotNull(seekBar);
                    seekBar.setProgress(100);
                    View view = CommonLayerProgressSection.this.mProgressRootView;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    eVar.h(downloadState.getMediaId());
                    return;
                }
                if (i3 == 2) {
                    View view2 = CommonLayerProgressSection.this.mProgressRootView;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    eVar.h(downloadState.getMediaId());
                    return;
                }
                if (i3 == 3) {
                    View view3 = CommonLayerProgressSection.this.mProgressRootView;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    int progressPercent = (int) (downloadState.getProgressPercent() * 100);
                    QLog.i("CommonLayerProgressSection", 1, "mediaId:" + downloadState.getMediaId() + " ,progress:" + progressPercent);
                    SeekBar seekBar2 = CommonLayerProgressSection.this.mProgressBar;
                    Intrinsics.checkNotNull(seekBar2);
                    if (progressPercent > seekBar2.getProgress()) {
                        SeekBar seekBar3 = CommonLayerProgressSection.this.mProgressBar;
                        Intrinsics.checkNotNull(seekBar3);
                        seekBar3.setProgress(progressPercent);
                        CommonLayerProgressSection.this.u(downloadState);
                    }
                }
            }
        }
    }

    public CommonLayerProgressSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.richmedia.section.CommonLayerProgressSection$mFileDownloadLoadStateObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommonLayerProgressSection.a invoke() {
                return new CommonLayerProgressSection.a();
            }
        });
        this.mFileDownloadLoadStateObserver = lazy;
    }

    private final Observer<RFWLayerFileDownloadState> t() {
        return (Observer) this.mFileDownloadLoadStateObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(RFWLayerFileDownloadState downloadState) {
        if (downloadState.getFileSize() != 0 && this.mProgressBar != null) {
            long fileSize = downloadState.getFileSize();
            Intrinsics.checkNotNull(this.mProgressBar);
            long progress = fileSize * r2.getProgress();
            Intrinsics.checkNotNull(this.mProgressBar);
            String str = "\u4e0b\u8f7d\u4e2d " + ao.a(progress / r2.getMax()) + "/" + ao.a(downloadState.getFileSize());
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        d dVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.az_) {
            View view = this.mProgressRootView;
            if (view != null) {
                view.setVisibility(8);
            }
            String mediaId = ((RFWLayerItemMediaInfo) this.mData).getMediaId();
            if (mediaId != null) {
                e eVar = e.f281568a;
                String name = d.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
                c d16 = eVar.d(name);
                if (d16 instanceof d) {
                    dVar = (d) d16;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.cancelDownload(mediaId);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        ImageView imageView;
        TextView textView;
        SeekBar seekBar;
        this.mProgressRootView = LayoutInflater.from(getRootView().getContext()).inflate(R.layout.e3g, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(110.0f));
        layoutParams.gravity = 80;
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.mProgressRootView, layoutParams);
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
            seekBar = (SeekBar) view4.findViewById(R.id.ilm);
        } else {
            seekBar = null;
        }
        this.mProgressBar = seekBar;
        if (seekBar != null) {
            seekBar.setEnabled(false);
        }
        ImageView imageView2 = this.mCancelBtn;
        if (imageView2 != null) {
            imageView2.setImageDrawable(b.f349994a.b(ResourcesCompat.getDrawable(getRootView().getResources(), R.drawable.qui_close_filled, null), ResourcesCompat.getColor(getRootView().getResources(), R.color.qui_common_feedback_error, null)));
        }
        ImageView imageView3 = this.mCancelBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(@NotNull RFWLayerItemMediaInfo data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (((RFWLayerItemMediaInfo) this.mData).isVideo() || !((RFWLayerItemMediaInfo) this.mData).isShowOriginPic() || TextUtils.isEmpty(((RFWLayerItemMediaInfo) this.mData).getExistSaveOrEditPath())) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerFileDownloadState.class, data.getMediaId(), t());
        }
    }
}
