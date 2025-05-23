package com.tencent.aelight.camera.ae.gif;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import dov.com.qq.im.ae.current.SessionWrap;

/* loaded from: classes32.dex */
public class AEStoryGIFPreviewActivity extends BaseVMPeakActivity {
    private String U;
    private String V;
    private SessionWrap X;
    private String R = null;
    private boolean S = false;
    private boolean T = false;
    private String W = "";

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 21 && i16 == -1) {
            setResult(201);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    protected boolean q0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aebase.BaseVMPeakActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.G = false;
        super.onCreate(bundle);
        setContentView(R.layout.dnz);
        String stringExtra = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
        getIntent().getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
        this.T = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
        this.U = getIntent().getStringExtra(AECameraConstants.ARG_GIF_MATERIAL_ID);
        this.W = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
        this.X = (SessionWrap) getIntent().getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
        boolean booleanExtra = getIntent().getBooleanExtra(AECameraConstants.ARG_GIF_SEND_TO_AIO, false);
        long longExtra = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", Long.MAX_VALUE);
        if (getIntent().hasExtra("KEY_FONT_ID")) {
            this.V = getIntent().getStringExtra("KEY_FONT_ID");
        }
        FragmentManager fragmentManager = getFragmentManager();
        ms.a.a("BaseActivity2", "[onCreate], materialApplied=" + this.T + ", materialId=" + this.U);
        if (!this.T && TextUtils.isEmpty(this.U)) {
            if (fragmentManager.findFragmentByTag(AEGIFChunkPreviewFragment.class.getSimpleName()) == null) {
                fragmentManager.beginTransaction().add(R.id.ru8, AEGIFChunkPreviewFragment.A(stringExtra, longExtra, this.V), AEGIFChunkPreviewFragment.class.getSimpleName()).commit();
            }
        } else if (fragmentManager.findFragmentByTag(AEGIFSinglePreviewFragment.class.getSimpleName()) == null) {
            fragmentManager.beginTransaction().add(R.id.ru8, AEGIFSinglePreviewFragment.y(stringExtra, Boolean.valueOf(this.T), this.U, this.W, this.X, booleanExtra, this.V), AEGIFSinglePreviewFragment.class.getSimpleName()).commit();
        }
    }
}
