package com.tencent.aelight.camera.aioeditor.takevideo.eliminate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import fs.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/eliminate/EditPicAIEliminatePart;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/u;", "Lcom/tencent/mobileqq/wink/editor/aielimination/IEditPicEliminateOpCallback;", "", "j0", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "editVideoState", "", "extra", "editVideoStateChanged", "fragmentIndex", "Lfs/b;", "generateContext", "editVideoPrePublish", "", "onBackPressed", "Landroid/graphics/Bitmap;", "getOriginBitmap", "isDo", "resultBitmap", "onEliminateResult", "", "getPartPlayGameName", "getPartPlayGameValue", "_isEliminateEdit", "Z", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;)V", "Companion", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class EditPicAIEliminatePart extends u implements IEditPicEliminateOpCallback {
    public static final String TAG = "EditPicAIEliminatePart";
    private boolean _isEliminateEdit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPicAIEliminatePart(EditVideoPartManager manager) {
        super(manager);
        Intrinsics.checkNotNullParameter(manager, "manager");
    }

    private final void j0() {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        FragmentTransaction addToBackStack;
        EliminateLayoutFragment a16 = EliminateLayoutFragment.INSTANCE.a(this);
        Activity activity = this.mUi.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(R.id.rtr, a16, "ELIMINATE_LAYOUT_TAG")) == null || (addToBackStack = add.addToBackStack("ELIMINATE_LAYOUT_TAG")) == null) {
            return;
        }
        addToBackStack.commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int fragmentIndex, b generateContext) {
        Intrinsics.checkNotNullParameter(generateContext, "generateContext");
        super.editVideoPrePublish(fragmentIndex, generateContext);
        if (this._isEliminateEdit) {
            generateContext.f400395l.f400420f++;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int editVideoState, Object extra) {
        super.editVideoStateChanged(editVideoState, extra);
        if (editVideoState == 28) {
            a.c();
            j0();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback
    public Bitmap getOriginBitmap() {
        return com.tencent.biz.qqstory.utils.b.i(this.mParent.S(), this.mParent.U().r());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public String getPartPlayGameName() {
        return WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public String getPartPlayGameValue() {
        if (this._isEliminateEdit) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.e(TAG, 1, "onActivityResult ");
        Activity activity = this.mUi.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        FragmentManager supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
        List<Fragment> fragments = supportFragmentManager != null ? supportFragmentManager.getFragments() : null;
        if (fragments != null) {
            int size = fragments.size();
            for (int i3 = 0; i3 < size; i3++) {
                fragments.get(i3).onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        FragmentManager.BackStackEntry backStackEntryAt;
        Activity activity = this.mUi.getActivity();
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        FragmentManager supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
        for (int backStackEntryCount = (supportFragmentManager != null ? supportFragmentManager.getBackStackEntryCount() : 0) - 1; -1 < backStackEntryCount; backStackEntryCount--) {
            String name = (supportFragmentManager == null || (backStackEntryAt = supportFragmentManager.getBackStackEntryAt(backStackEntryCount)) == null) ? null : backStackEntryAt.getName();
            if (Intrinsics.areEqual(name, "ELIMINATION_TAG")) {
                supportFragmentManager.popBackStack();
            }
            if (Intrinsics.areEqual(name, "ELIMINATE_LAYOUT_TAG")) {
                supportFragmentManager.popBackStack();
                onEliminateResult(false, null);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.IEditPicEliminateOpCallback
    public void onEliminateResult(boolean isDo, Bitmap resultBitmap) {
        w53.b.a(TAG, "onEliminateResult isDo: " + isDo + ", resultBitmap: " + resultBitmap + " ");
        this.mParent.t(0);
        if (!isDo || resultBitmap == null) {
            return;
        }
        this._isEliminateEdit = true;
        Bundle bundle = this.mParent.Y;
        if (bundle != null) {
            bundle.remove(FaceLayer.f67956d0);
            this.mParent.Y.remove("DynamicFaceLayer");
            this.mParent.Y.remove(g.f67980d0);
        }
        m.n().S(resultBitmap);
        this.mParent.e1(resultBitmap, false);
    }
}
