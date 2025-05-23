package com.tencent.mobileqq.qqvideoedit.editor.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut;
import com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.qqvideoedit.utils.o;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e extends com.tencent.mobileqq.qqvideoedit.editor.d {
    private static final String H = "e";
    private LinearLayout D;
    private VideoEditorViewModel E;
    private MusicVolumeControlViewModel F;
    private long G;

    private void T9(View view, MenuType menuType) {
        if (menuType == MenuType.SWITCH_VOLUME) {
            view.setSelected(true);
            this.F.W1(view.isSelected(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(List<MenuItem> list) {
        if (list == null) {
            return;
        }
        this.D.removeAllViews();
        int c16 = x.c(getContext(), 24.0f);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            final MenuItem menuItem = list.get(i3);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h1j, (ViewGroup) this.D, false);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.z3b);
            imageView.setTag(menuItem.getMenuType());
            imageView.setImageResource(menuItem.getIcon());
            T9(inflate, menuItem.getMenuType());
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.menu.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.V9(menuItem, imageView, view);
                }
            });
            inflate.setPadding(0, 0, c16, 0);
            this.D.addView(inflate, new LinearLayout.LayoutParams(-2, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V9(MenuItem menuItem, ImageView imageView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        aa(view, menuItem.getMenuType(), imageView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W9(DialogInterface dialogInterface, int i3) {
        this.E.y2(MenuType.TO_VIDEO, null);
    }

    private void Y9(View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_size");
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    private void Z9(View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_word");
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    private void aa(View view, MenuType menuType, ImageView imageView) {
        int i3;
        int i16;
        if (menuType == MenuType.TO_VIDEO && !AECameraPrefsUtil.b().a(AECameraPrefsUtil.f275092g, false, 0) && F9() != null && F9().U()) {
            try {
                AECameraPrefsUtil.b().d(AECameraPrefsUtil.f275092g, true, 0);
                DialogUtil.createCustomDialog(getContext(), 230).setMessage(getContext().getResources().getString(R.string.f238087it)).setPositiveButton(getContext().getString(R.string.f238077is), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.menu.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i17) {
                        e.this.W9(dialogInterface, i17);
                    }
                }).setNegativeButton(getContext().getString(R.string.f238067ir), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.menu.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i17) {
                        e.X9(dialogInterface, i17);
                    }
                }).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (menuType == MenuType.BACKGROUND && (F9() instanceof VideoTavCut) && ((VideoTavCut) F9()).getTemplatePath() != null) {
            QQToast.makeText(getContext(), -1, getContext().getString(R.string.f237787i0), 0).show();
            return;
        }
        if (menuType == MenuType.ENHANCE) {
            boolean d06 = F9().d0();
            ba(d06);
            this.E.v2(d06);
            return;
        }
        if (menuType == MenuType.SWITCH_VOLUME) {
            if (ca()) {
                return;
            }
            view.setSelected(!view.isSelected());
            boolean isSelected = view.isSelected();
            this.F.W1(isSelected, false);
            o oVar = o.f276259a;
            Context context = getContext();
            Context context2 = getContext();
            if (isSelected) {
                i3 = R.string.f237807i2;
            } else {
                i3 = R.string.f237797i1;
            }
            oVar.c(context, context2.getString(i3));
            if (isSelected) {
                i16 = R.drawable.qui_voice_high_icon_white;
            } else {
                i16 = R.drawable.qui_voice_mute_icon_white;
            }
            imageView.setImageResource(i16);
            com.tencent.mobileqq.qqvideoedit.editor.c.o(view);
            return;
        }
        if (menuType == MenuType.TEXT) {
            Z9(view);
        } else if (menuType == MenuType.CROP) {
            Y9(view);
        }
        this.E.y2(menuType, null);
    }

    private boolean ca() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.G;
        if (currentTimeMillis - j3 < 500 && currentTimeMillis > j3) {
            if (QLog.isColorLevel()) {
                QLog.e(H, 2, "volumeBtnClickOverFrequency, please try again later!");
                return true;
            }
            return true;
        }
        this.G = currentTimeMillis;
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.t9k;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return H;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = (LinearLayout) getPartRootView();
        this.E = (VideoEditorViewModel) getViewModel(VideoEditorViewModel.class);
        FragmentActivity activity = getHostFragment().getActivity();
        if (activity != null) {
            this.F = (MusicVolumeControlViewModel) new ViewModelProvider(activity).get(MusicVolumeControlViewModel.class);
        }
        this.videoEditorViewModel.Q1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.menu.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.U9((List) obj);
            }
        });
    }

    public void ba(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X9(DialogInterface dialogInterface, int i3) {
    }
}
