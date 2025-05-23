package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class u implements IEventReceiver {
    protected long mAnimationEndTime;
    protected boolean mIsDestroy;
    public final EditVideoPartManager mParent;
    protected aa mUi;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
    }

    public u(EditVideoPartManager editVideoPartManager) {
        this.mParent = editVideoPartManager;
    }

    private void i0() {
        if (this.mUi == null) {
            IllegalStateException illegalStateException = new IllegalStateException("have not attached ui");
            QLog.e("EditVideoPart", 1, "checkState error! ", illegalStateException);
            im2.b.a(illegalStateException);
        }
    }

    public void attachEditVideoUi(aa aaVar) {
        if (this.mUi != null) {
            throw new IllegalStateException("attach context duplicate");
        }
        if (aaVar != null) {
            this.mUi = aaVar;
            return;
        }
        throw new IllegalArgumentException("ui should not be null");
    }

    public final boolean dispatchEditVideoMessage(Message message) {
        boolean handleEditVideoMessage = handleEditVideoMessage(message);
        message.recycle();
        return handleEditVideoMessage;
    }

    @Deprecated
    public void editVideoPrePublish(fs.b bVar) {
    }

    public void editVideoStateChanged(int i3, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View findViewSure(int i3) {
        i0();
        View findViewById = this.mUi.getRootView().findViewById(i3);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("can not find view by id " + i3);
    }

    public Context getContext() {
        i0();
        return this.mUi.getContext();
    }

    public a getEditExport(Class<? extends a> cls) {
        i0();
        return this.mParent.R(cls);
    }

    public int getOpIn() {
        return this.mParent.Y();
    }

    public String getPartPlayGameName() {
        return null;
    }

    public String getPartPlayGameValue() {
        return null;
    }

    public Resources getResources() {
        i0();
        return this.mUi.getContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(int i3) {
        i0();
        return getResources().getString(i3);
    }

    public aa getUi() {
        i0();
        return this.mUi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleEditVideoMessage(Message message) {
        return false;
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return this.mParent.isValidate();
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        i0();
    }

    public boolean onBackPressed() {
        i0();
        return false;
    }

    public void onCreate() {
        i0();
    }

    public void onPause() {
        i0();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        i0();
    }

    public void onResume() {
        i0();
    }

    public void onSaveInstanceState(Bundle bundle) {
        i0();
    }

    public void onStart() {
        i0();
    }

    public void onStop() {
        i0();
    }

    public void onWindowFocusChanged(boolean z16) {
        i0();
    }

    public void publishEditExport(Class<? extends a> cls, a aVar) {
        i0();
        this.mParent.T0(cls, aVar);
    }

    public void detachEditVideoUi() {
        this.mUi = null;
    }

    public void editVideoPostPublish(fs.b bVar) {
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).o(this.mUi.getActivity());
    }

    public void editVideoPrePublish(int i3, fs.b bVar) {
        editVideoPrePublish(bVar);
    }

    public void editVideoStateChanged(int i3, int i16, Object obj) {
        editVideoStateChanged(i16, obj);
    }

    public void onDestroy() {
        this.mIsDestroy = true;
        detachEditVideoUi();
    }

    public void editVideoPublishError(Error error) {
    }

    public void editVideoPublish() {
    }

    public void onActivityFinish() {
    }
}
