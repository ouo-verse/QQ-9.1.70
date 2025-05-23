package com.tencent.aelight.camera.aioeditor.takevideo.mosaic;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicLayoutFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "callback", "<init>", "()V", "D", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MosaicLayoutFragment extends ImmersivePartFragment {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private IEditPicMosaicOpCallback callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicLayoutFragment$a;", "", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "provider", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicLayoutFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicLayoutFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MosaicLayoutFragment a(IEditPicMosaicOpCallback provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            MosaicLayoutFragment mosaicLayoutFragment = new MosaicLayoutFragment();
            mosaicLayoutFragment.callback = provider;
            return mosaicLayoutFragment;
        }

        Companion() {
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        Object obj;
        EditVideoPartManager manager;
        List<u> parts;
        Object obj2;
        ArrayList arrayList = new ArrayList();
        MosaicLayoutPart mosaicLayoutPart = new MosaicLayoutPart();
        if (this.callback == null) {
            Activity hostActivity = getHostActivity();
            EditPicActivity editPicActivity = hostActivity instanceof EditPicActivity ? (EditPicActivity) hostActivity : null;
            if (editPicActivity == null || (manager = editPicActivity.getManager()) == null || (parts = manager.Z()) == null) {
                obj = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(parts, "parts");
                Iterator<T> it = parts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (((u) obj2) instanceof EditPicMosaicPart) {
                        break;
                    }
                }
                obj = (u) obj2;
            }
            this.callback = obj instanceof IEditPicMosaicOpCallback ? (IEditPicMosaicOpCallback) obj : null;
        }
        mosaicLayoutPart.X9(this.callback);
        arrayList.add(mosaicLayoutPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dli;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }
}
