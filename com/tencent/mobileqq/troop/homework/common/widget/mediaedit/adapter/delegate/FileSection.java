package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.FileItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaUploadStateView;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/FileSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", "data", "", "y", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "v", "f", "I", "paddingHor", tl.h.F, "paddingBt", "i", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", "curItem", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "fileNameTv", BdhLogUtil.LogTag.Tag_Conn, "fileSizeTv", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "fileIconIv", "E", "delIv", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", "progressView", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class FileSection extends BaseMediaEditSection<FileItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView fileSizeTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView fileIconIv;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView delIv;

    /* renamed from: F, reason: from kotlin metadata */
    private HWMediaUploadStateView progressView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int paddingHor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int paddingBt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FileItem curItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView fileNameTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/FileSection$a;", "", "", "FILE_ICON_KEY", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.FileSection$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileSection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.paddingHor = ViewUtils.dip2px(16.0f);
            this.paddingBt = ViewUtils.dip2px(16.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FileSection this$0, View this_apply, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        FileItem fileItem = this$0.curItem;
        if (fileItem != null) {
            qs2.a q16 = this$0.q();
            Context context = this_apply.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            q16.m(fileItem, activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(FileSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileItem fileItem = this$0.curItem;
        if (fileItem != null) {
            this$0.q().y(fileItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(FileItem data) {
        int i3;
        HWMediaUploadStateView hWMediaUploadStateView;
        int f06;
        if (data.isSupportDelete()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        ImageView imageView = this.delIv;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delIv");
            imageView = null;
        }
        if (imageView.getVisibility() != i3) {
            ImageView imageView3 = this.delIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delIv");
                imageView3 = null;
            }
            imageView3.setVisibility(i3);
        }
        HWMediaUploadStateView hWMediaUploadStateView2 = this.progressView;
        if (hWMediaUploadStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            hWMediaUploadStateView = null;
        } else {
            hWMediaUploadStateView = hWMediaUploadStateView2;
        }
        HWMediaUploadStateView.e(hWMediaUploadStateView, data.getState(), data.getProgress(), 0, 4, null);
        TextView textView = this.fileNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileNameTv");
            textView = null;
        }
        if (!Intrinsics.areEqual(textView.getText(), data.getFileName())) {
            TextView textView2 = this.fileNameTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileNameTv");
                textView2 = null;
            }
            textView2.setText(data.getFileName());
        }
        String d16 = HWNoticeUtils.f297171a.d(data.getFileSize());
        TextView textView3 = this.fileSizeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileSizeTv");
            textView3 = null;
        }
        if (!Intrinsics.areEqual(textView3.getText(), d16)) {
            TextView textView4 = this.fileSizeTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileSizeTv");
                textView4 = null;
            }
            textView4.setText(d16);
        }
        ImageView imageView4 = this.fileIconIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileIconIv");
            imageView4 = null;
        }
        if (Intrinsics.areEqual(imageView4.getTag(-1), data.getFileName())) {
            return;
        }
        if (data.getFileType() != -1) {
            f06 = ah.d0(data.getFileType());
        } else {
            f06 = ah.f0(data.getFileName());
        }
        ImageView imageView5 = this.fileIconIv;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileIconIv");
            imageView5 = null;
        }
        imageView5.setImageResource(f06);
        ImageView imageView6 = this.fileIconIv;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileIconIv");
        } else {
            imageView2 = imageView6;
        }
        imageView2.setTag(-1, data.getFileName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11915763};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.BaseMediaEditSection, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable final View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        super.onInitView(containerView);
        if (containerView != null) {
            int i3 = this.paddingHor;
            containerView.setPadding(i3, 0, i3, this.paddingBt);
            View findViewById = containerView.findViewById(R.id.f165851xu0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.item_file_layer)");
            TriggerRunnerKt.c(findViewById, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FileSection.w(FileSection.this, containerView, view);
                }
            }, 1, null);
            View findViewById2 = containerView.findViewById(R.id.f165852xu1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_file_name)");
            this.fileNameTv = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f165853xu2);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.item_file_size)");
            this.fileSizeTv = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.xtz);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.item_file_icon)");
            this.fileIconIv = (ImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.xt7);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.item_del_iv)");
            ImageView imageView = (ImageView) findViewById5;
            this.delIv = imageView;
            HWMediaUploadStateView hWMediaUploadStateView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delIv");
                imageView = null;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FileSection.x(FileSection.this, view);
                }
            });
            View findViewById6 = containerView.findViewById(R.id.xwq);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.item_progress_view)");
            HWMediaUploadStateView hWMediaUploadStateView2 = (HWMediaUploadStateView) findViewById6;
            this.progressView = hWMediaUploadStateView2;
            if (hWMediaUploadStateView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
            } else {
                hWMediaUploadStateView = hWMediaUploadStateView2;
            }
            hWMediaUploadStateView.setOnRetryClickListener(new Function0<Unit>(containerView) { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.FileSection$onInitView$1$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$this_apply = containerView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileSection.this, (Object) containerView);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FileItem fileItem;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    fileItem = FileSection.this.curItem;
                    if (fileItem != null) {
                        FileSection fileSection = FileSection.this;
                        View view = this.$this_apply;
                        if (fileItem.getState() == UploadOrDownloadState.DOWNLOAD_ERR) {
                            qs2.a q16 = fileSection.q();
                            Context context = view.getContext();
                            q16.m(fileItem, context instanceof Activity ? (Activity) context : null);
                        } else if (fileItem.getState() == UploadOrDownloadState.UPLOAD_ERR) {
                            fileSection.q().j(fileItem);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable FileItem data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else {
            if (data == null) {
                return;
            }
            this.curItem = data;
            y(data);
        }
    }
}
