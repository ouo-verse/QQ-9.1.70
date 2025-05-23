package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.PropDownloadIconStatusListener;
import com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.sail.room.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends ViewModel {
    static IPatchRedirector $redirector_;
    private final IAegisLogApi C;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a f270528i;

    /* renamed from: m, reason: collision with root package name */
    private PropDownloadIconStatusListener f270529m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements AEMetaDataUtils.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void a(AEMaterialMetaData aEMaterialMetaData, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aEMaterialMetaData, i3);
                return;
            }
            b.this.f270528i.f(1);
            b bVar = b.this;
            bVar.Q1(bVar.f270528i, PropDownloadIconStatusListener.IconType.ICON_PROGRESS);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void b(AEMaterialMetaData aEMaterialMetaData, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aEMaterialMetaData, i3);
                return;
            }
            b.this.f270528i.f(0);
            b.this.f270528i.h("");
            b bVar = b.this;
            bVar.Q1(bVar.f270528i, PropDownloadIconStatusListener.IconType.ICON_DOWNLOAD);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void c(AEMaterialMetaData aEMaterialMetaData, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aEMaterialMetaData, (Object) str);
                return;
            }
            BeautyProcessor.n().I(str);
            if (aEMaterialMetaData.f69050id.startsWith("video_zplan_filament_ar")) {
                b.T1(30);
            } else {
                b.T1(15);
            }
            b.this.f270528i.f(2);
            b.this.f270528i.h(str);
            b bVar = b.this;
            bVar.Q1(bVar.f270528i, PropDownloadIconStatusListener.IconType.ICON_NULL);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.utils.AEMetaDataUtils.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b.this.f270528i.f(1);
            b bVar = b.this;
            bVar.Q1(bVar.f270528i, PropDownloadIconStatusListener.IconType.ICON_PROGRESS);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, PropDownloadIconStatusListener.IconType iconType) {
        PropDownloadIconStatusListener propDownloadIconStatusListener = this.f270529m;
        if (propDownloadIconStatusListener != null) {
            propDownloadIconStatusListener.a(aVar, iconType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(@NonNull final com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, final PropDownloadIconStatusListener.IconType iconType) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.viewmodel.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.P1(aVar, iconType);
            }
        });
    }

    public static void T1(int i3) {
        d dVar;
        TRTCVideoQualityParams videoQuality;
        com.tencent.mobileqq.qqlive.sail.room.c m3 = com.tencent.mobileqq.qqlive.sail.c.f272176a.d().m();
        if (!(m3 instanceof IQQLiveAnchorTRTCRoom) || (videoQuality = (dVar = (d) m3).getVideoQuality()) == null) {
            return;
        }
        TRTCVideoQualityParams.Builder builder = new TRTCVideoQualityParams.Builder();
        builder.setVideoResolution(videoQuality.getVideoResolution()).setVideoFps(i3).setVideoBitRate(videoQuality.getVideoBitRate()).setMinVideoBitRate(videoQuality.getMinVideoBitRate()).setVideoResolutionMode(1);
        dVar.setVideoQuality(builder.build());
    }

    public com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f270528i;
    }

    public void R1(@NonNull com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f270528i = aVar;
        }
    }

    public void S1(PropDownloadIconStatusListener propDownloadIconStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) propDownloadIconStatusListener);
        } else {
            this.f270529m = propDownloadIconStatusListener;
        }
    }

    public void U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar = this.f270528i;
        if (aVar == null) {
            this.C.e("PropItemViewModel", "updatePropEffect failed, item == null");
            return;
        }
        if (aVar.c() == 1) {
            this.C.e("PropItemViewModel", "updatePropEffect failed, item is downloading, item name = " + this.f270528i.f270502l + ", custom id = " + this.f270528i.f270491a);
            return;
        }
        AEMetaDataUtils.l(this.f270528i, new a());
    }
}
