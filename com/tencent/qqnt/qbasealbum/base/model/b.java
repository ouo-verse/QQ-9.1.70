package com.tencent.qqnt.qbasealbum.base.model;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.view.DownLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010J\u001a\u00020\u0007\u00a2\u0006\u0004\bK\u0010!J^\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010/\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b\n\u0010-\"\u0004\b\u0015\u0010.R$\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00109\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b7\u0010-\"\u0004\b8\u0010.R$\u0010=\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010I\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0016\u001a\u0004\bG\u0010\u0018\"\u0004\bH\u0010\u001a\u00a8\u0006L"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/model/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMedia", "", "layoutPosition", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "onItemClick", "onItemSelect", "l", "progress", "H", "info", "I", "J", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/widget/ImageView;)V", "mediaThumb", UserInfo.SEX_FEMALE, "Landroid/view/View;", "u", "()Landroid/view/View;", "D", "(Landroid/view/View;)V", "selectMask", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "G", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "B", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "selectCheckBox", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "videoDuration", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "t", "()Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/widget/FrameLayout;)V", "selectContainer", "p", "y", "mediaFlag", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "downloadView", "Lcom/tencent/qqnt/qbasealbum/view/DownLoadingView;", "L", "Lcom/tencent/qqnt/qbasealbum/view/DownLoadingView;", "r", "()Lcom/tencent/qqnt/qbasealbum/view/DownLoadingView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/qqnt/qbasealbum/view/DownLoadingView;)V", "progressView", "M", "o", HippyTKDListViewAdapter.X, "editFlag", "itemView", "<init>", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView mediaThumb;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View selectMask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QUICheckBox selectCheckBox;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView videoDuration;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private FrameLayout selectContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mediaFlag;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView downloadView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private DownLoadingView progressView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView editFlag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    public final void A(@Nullable DownLoadingView downLoadingView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) downLoadingView);
        } else {
            this.progressView = downLoadingView;
        }
    }

    public final void B(@Nullable QUICheckBox qUICheckBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qUICheckBox);
        } else {
            this.selectCheckBox = qUICheckBox;
        }
    }

    public final void C(@Nullable FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameLayout);
        } else {
            this.selectContainer = frameLayout;
        }
    }

    public final void D(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.selectMask = view;
        }
    }

    public final void E(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
        } else {
            this.videoDuration = textView;
        }
    }

    public void H(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, progress);
        }
    }

    public void I(@NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    public void J(@NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    public abstract void l(@NotNull LocalMediaInfo localMedia, int layoutPosition, @NotNull Function1<? super View, Unit> onItemClick, @NotNull Function1<? super View, Unit> onItemSelect);

    @Nullable
    public final ImageView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ImageView) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.downloadView;
    }

    @Nullable
    public final ImageView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ImageView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.editFlag;
    }

    @Nullable
    public final TextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mediaFlag;
    }

    @Nullable
    public final ImageView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mediaThumb;
    }

    @Nullable
    public final DownLoadingView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (DownLoadingView) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.progressView;
    }

    @Nullable
    public final QUICheckBox s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUICheckBox) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.selectCheckBox;
    }

    @Nullable
    public final FrameLayout t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.selectContainer;
    }

    @Nullable
    public final View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.selectMask;
    }

    @Nullable
    public final TextView v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.videoDuration;
    }

    public final void w(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) imageView);
        } else {
            this.downloadView = imageView;
        }
    }

    public final void x(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) imageView);
        } else {
            this.editFlag = imageView;
        }
    }

    public final void y(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            this.mediaFlag = textView;
        }
    }

    public final void z(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView);
        } else {
            this.mediaThumb = imageView;
        }
    }
}
