package com.tencent.aelight.camera.aioeditor.takevideo.mosaic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/EditPicMosaicPart;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/u;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/IEditPicMosaicOpCallback;", "", "j0", "onCreate", "", "editVideoState", "", "extra", "editVideoStateChanged", "fragmentIndex", "Lfs/b;", "generateContext", "editVideoPrePublish", "", "onBackPressed", "Landroid/graphics/Bitmap;", "getOriginBitmap", "isDo", "resultBitmap", "onMosaicResult", "", "getPartPlayGameName", "getPartPlayGameValue", "_isMosaicEdit", "Z", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;)V", "Companion", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class EditPicMosaicPart extends u implements IEditPicMosaicOpCallback {
    public static final String TAG_FRAGMENT = "frag_mosaic";
    private boolean _isMosaicEdit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPicMosaicPart(EditVideoPartManager manager) {
        super(manager);
        Intrinsics.checkNotNullParameter(manager, "manager");
    }

    private final void j0() {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        FragmentTransaction addToBackStack;
        MosaicLayoutFragment a16 = MosaicLayoutFragment.INSTANCE.a(this);
        Activity activity = this.mUi.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(R.id.rtr, a16, TAG_FRAGMENT)) == null || (addToBackStack = add.addToBackStack(TAG_FRAGMENT)) == null) {
            return;
        }
        addToBackStack.commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int fragmentIndex, fs.b generateContext) {
        Intrinsics.checkNotNullParameter(generateContext, "generateContext");
        super.editVideoPrePublish(fragmentIndex, generateContext);
        if (this._isMosaicEdit) {
            generateContext.f400395l.f400420f++;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int editVideoState, Object extra) {
        super.editVideoStateChanged(editVideoState, extra);
        if (editVideoState == 27) {
            j0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.mosaic.IEditPicMosaicOpCallback
    public Bitmap getOriginBitmap() {
        return com.tencent.biz.qqstory.utils.b.i(this.mParent.S(), this.mParent.U().r());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public String getPartPlayGameName() {
        return WinkDaTongReportConstant.ElementParamKey.XSJ_MOSAIC_CHANGED;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public String getPartPlayGameValue() {
        if (this._isMosaicEdit) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        Activity activity = this.mUi.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        FragmentManager supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
        if ((supportFragmentManager != null ? supportFragmentManager.getBackStackEntryCount() : 0) <= 0 || supportFragmentManager == null) {
            return false;
        }
        onMosaicResult(false, null);
        MosaicLayoutPart.INSTANCE.a();
        supportFragmentManager.popBackStack();
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.mosaic.IEditPicMosaicOpCallback
    public void onMosaicResult(boolean isDo, Bitmap resultBitmap) {
        this.mParent.t(0);
        if (!isDo || resultBitmap == null) {
            return;
        }
        this._isMosaicEdit = true;
        Bundle bundle = this.mParent.Y;
        if (bundle != null) {
            bundle.remove(FaceLayer.f67956d0);
            this.mParent.Y.remove("DynamicFaceLayer");
            this.mParent.Y.remove(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0);
        }
        m.n().S(resultBitmap);
        this.mParent.e1(resultBitmap, false);
    }
}
