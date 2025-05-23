package ck2;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportProgress;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.GsonUtils;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H$J\b\u0010\u0013\u001a\u00020\u0006H\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lck2/f;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "V9", "T9", "aa", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "vm", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/b;", "state", "W9", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originInfo", "Y9", "U9", "Ldk2/a;", "D", "Ldk2/a;", "S9", "()Ldk2/a;", "setVideoExportProgressDialog", "(Ldk2/a;)V", "videoExportProgressDialog", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "E", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "R9", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setNextButton", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "nextButton", UserInfo.SEX_FEMALE, "I", "Q9", "()I", "Z9", "(I)V", "exportFrom", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class f extends com.tencent.mobileqq.qqvideoedit.editor.d {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private dk2.a videoExportProgressDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QUIButton nextButton;

    /* renamed from: F, reason: from kotlin metadata */
    private int exportFrom;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqvideoedit.editor.export.a.g().b(true);
        com.tencent.mobileqq.qqvideoedit.editor.c.p(view);
        dk2.a aVar = this$0.videoExportProgressDialog;
        if (aVar != null) {
            aVar.cancel();
        }
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.zqg;
    }

    /* renamed from: Q9, reason: from getter */
    public final int getExportFrom() {
        return this.exportFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: R9, reason: from getter */
    public final QUIButton getNextButton() {
        return this.nextButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: S9, reason: from getter */
    public final dk2.a getVideoExportProgressDialog() {
        return this.videoExportProgressDialog;
    }

    protected abstract void U9();

    public void W9(@NotNull VideoExportViewModel vm5, @NotNull VideoExportProgress state) {
        long j3;
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(state, "state");
        int status = state.getStatus();
        if (status != 0) {
            if (status != 1) {
                if (status != 2) {
                    if (status == 3) {
                        com.tencent.mobileqq.qqvideoedit.editor.c.m(this.nextButton, GsonUtils.obj2Json(state));
                        dk2.a aVar = this.videoExportProgressDialog;
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        U9();
                        return;
                    }
                    return;
                }
                LocalMediaInfo z95 = z9();
                QUIButton qUIButton = this.nextButton;
                if (z95 != null) {
                    j3 = z95.mDuration;
                } else {
                    j3 = 0;
                }
                com.tencent.mobileqq.qqvideoedit.editor.c.n(qUIButton, j3, state.getProcessTime());
                dk2.a aVar2 = this.videoExportProgressDialog;
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
                Y9(vm5, state, z95);
                return;
            }
            dk2.a aVar3 = this.videoExportProgressDialog;
            if (aVar3 != null) {
                aVar3.Q(state.getProgress());
                return;
            }
            return;
        }
        if (getContext() != null) {
            dk2.a aVar4 = new dk2.a(getActivity(), B9());
            this.videoExportProgressDialog = aVar4;
            aVar4.O(new View.OnClickListener() { // from class: ck2.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.X9(f.this, view);
                }
            });
            dk2.a aVar5 = this.videoExportProgressDialog;
            if (aVar5 != null) {
                aVar5.Q(0);
            }
            aa();
            dk2.a aVar6 = this.videoExportProgressDialog;
            if (aVar6 != null) {
                aVar6.show();
            }
        }
    }

    protected abstract void Y9(@NotNull VideoExportViewModel vm5, @NotNull VideoExportProgress state, @Nullable LocalMediaInfo originInfo);

    public final void Z9(int i3) {
        this.exportFrom = i3;
    }

    public void aa() {
        dk2.a aVar = this.videoExportProgressDialog;
        if (aVar != null) {
            aVar.P(R.string.f237667ho);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        QUIButton qUIButton;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View partRootView = getPartRootView();
        if (partRootView instanceof QUIButton) {
            qUIButton = (QUIButton) partRootView;
        } else {
            qUIButton = null;
        }
        this.nextButton = qUIButton;
    }

    public void T9() {
    }

    public void V9() {
    }
}
