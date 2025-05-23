package com.tencent.qqnt.qbasealbum.album.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.qbasealbum.event.HalfModeExitEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/b;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "A9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "d", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "", "e", "Ljava/lang/String;", "MODE_SELECT_PAG_ID", "f", "TAG", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String MODE_SELECT_PAG_ID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qbasealbum/album/view/b$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF58528d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Context context = b.this.getContext();
            if (context != null) {
                return new QAlbumModeRadioGroup(context, b.this.getActivity().getIntent().getBooleanExtra("hide_setting_text", false), null, 0, 12, null);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.MODE_SELECT_PAG_ID = "pg_bas_picture_selector_floating_layer";
            this.TAG = "ModeSettingPart";
        }
    }

    private final void A9() {
        VideoReport.setPageId(this.mFloatingView, this.MODE_SELECT_PAG_ID);
        VideoReport.reportEvent("dt_pgin", this.mFloatingView, null);
    }

    private final void B9() {
        VideoReport.setPageId(this.mFloatingView, this.MODE_SELECT_PAG_ID);
        VideoReport.reportEvent("dt_pgout", this.mFloatingView, null);
    }

    private final void C9() {
        try {
            getActivity().setRequestedOrientation(1);
        } catch (Exception e16) {
            QLog.i(this.TAG, 1, "requestedOrientation exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (com.tencent.qqnt.qbasealbum.utils.a.f361642a.a() == 2) {
            SimpleEventBus.getInstance().dispatchEvent(new HalfModeExitEvent());
        }
        this$0.B9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        RFWImmersiveUtils.setTransparentStatusBar(getActivity().getWindow());
        RFWImmersiveUtils.setImmersiveLayout(getActivity().getWindow(), false);
        C9();
        if (rootView != null) {
            qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) rootView.findViewById(R.id.sko);
        } else {
            qUSHalfScreenFloatingView = null;
        }
        this.mFloatingView = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new a());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.qqnt.qbasealbum.album.view.a
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    b.z9(b.this);
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setIsHeightWrapContent(true);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mFloatingView;
        if (qUSHalfScreenFloatingView4 != null) {
            qUSHalfScreenFloatingView4.setContentDescription(getActivity().getString(R.string.f168062em));
        }
        A9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
        }
    }
}
