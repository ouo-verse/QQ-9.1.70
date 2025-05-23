package com.tencent.mobileqq.wink.templatelibrary.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.api.IWinkShareAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MateActivityUIStyle;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.event.FavoriteMaterialEvent;
import com.tencent.mobileqq.wink.share.p;
import com.tencent.mobileqq.wink.templatelibrary.WinkTemplatePreviewFragment;
import com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter;
import com.tencent.mobileqq.wink.templatelibrary.jump.TemplateJumpImpl;
import com.tencent.mobileqq.wink.utils.WinkTemplateFavouriteIdUtils2;
import com.tencent.mobileqq.wink.utils.aa;
import com.tencent.mobileqq.wink.utils.aw;
import com.tencent.mobileqq.wink.utils.v;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.wink.view.ao;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes21.dex */
public class TemplatePreviewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int K = ImmersiveUtils.dpToPx(6.0f);
    private static final int L = ImmersiveUtils.dpToPx(5.0f);
    private static final int M = ImmersiveUtils.dpToPx(5.0f);
    private final Context E;
    private int F;
    private String G;
    private QQPermission H;
    private boolean I;

    /* renamed from: m, reason: collision with root package name */
    private final List<MetaMaterial> f326420m;
    private final aw C = aw.e();
    private final WinkTemplateFavouriteIdUtils2 D = WinkTemplateFavouriteIdUtils2.f326648a;
    private final LinkedHashSet<WeakReference<BaseVideoView>> J = new LinkedHashSet<>();

    /* loaded from: classes21.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView E;
        private final TextView F;
        private final ImageView G;
        private final ImageView H;
        private final TextView I;
        private final QUIButton J;
        private final ImageView K;
        private final ImageView L;
        private BaseVideoView M;
        private final RoundCorneredRelativeLayout N;
        private final URLImageView P;
        private final TextView Q;
        private final SeekBar R;
        private SimpleDateFormat S;
        private int T;
        private final LinearLayout U;
        private volatile boolean V;
        private MetaMaterial W;
        private QCircleCommonLoadingDialog X;
        private TemplateJumpImpl Y;
        private final Runnable Z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes21.dex */
        public class a implements com.tencent.mobileqq.wink.templatelibrary.jump.b {
            a() {
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.b
            public boolean a() {
                if (!ViewHolder.this.V) {
                    return false;
                }
                return true;
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.b
            public QQPermission b() {
                return TemplatePreviewAdapter.this.H;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes21.dex */
        public class b implements com.tencent.mobileqq.wink.templatelibrary.jump.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f326427a;

            b(MetaMaterial metaMaterial) {
                this.f326427a = metaMaterial;
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
            public boolean a() {
                return false;
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
            public void b(boolean z16, int i3) {
                QLog.d("TemplatePreviewAdapter", 1, "[navToMaterial] onDownloadFinish, isSuccess:", Boolean.valueOf(z16), ",code:", Integer.valueOf(i3));
                if (ViewHolder.this.X != null && ViewHolder.this.X.isShowing()) {
                    ViewHolder.this.X.dismiss();
                }
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
            public void c(int i3) {
                QLog.d("TemplatePreviewAdapter", 1, "[navToMaterial] onJumpError:", Integer.valueOf(i3));
                if (ViewHolder.this.X != null && ViewHolder.this.X.isShowing()) {
                    ViewHolder.this.X.dismiss();
                }
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
            public void onDownloadStart() {
                QLog.d("TemplatePreviewAdapter", 1, "[navToMaterial] onDownloadStart");
                ViewHolder.this.m0(false, this.f326427a.f30533id);
                if (ViewHolder.this.X != null) {
                    ViewHolder.this.X.show();
                }
            }

            @Override // com.tencent.mobileqq.wink.templatelibrary.jump.a
            public void onProgressUpdate(int i3) {
                if (ViewHolder.this.X != null && ViewHolder.this.X.isShowing()) {
                    ViewHolder.this.X.setProgress(i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes21.dex */
        public class c implements DialogInterface.OnDismissListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f326429d;

            c(String str) {
                this.f326429d = str;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ViewHolder.this.Y != null) {
                    ViewHolder.this.Y.f(this.f326429d);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes21.dex */
        public class d implements SeekBar.OnSeekBarChangeListener {
            d() {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                if (ViewHolder.this.M != null && z16) {
                    long videoDurationMs = ViewHolder.this.M.getVideoDurationMs();
                    int i06 = ViewHolder.this.i0(i3, seekBar.getMax(), videoDurationMs);
                    ViewHolder.this.M.seekTo(i06);
                    ViewHolder.this.T = i3;
                    ViewHolder.this.J0(i06, videoDurationMs);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (ViewHolder.this.M == null) {
                    return;
                }
                ViewHolder.this.M.pause();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                if (ViewHolder.this.M != null) {
                    ViewHolder.this.q0();
                    ViewHolder.this.M.seekTo(ViewHolder.this.i0(seekBar.getProgress(), seekBar.getMax(), ViewHolder.this.M.getVideoDurationMs()));
                    ViewHolder.this.M.resume();
                }
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }
        }

        public ViewHolder(View view) {
            super(view);
            this.S = null;
            this.T = -1;
            this.X = null;
            this.Z = new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter.ViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ViewHolder.this.W == null) {
                        QLog.w("TemplatePreviewAdapter", 1, "[predownloadRunnable] invalid material");
                    } else {
                        if (!WinkEditorResourceManager.a1().q(ViewHolder.this.W)) {
                            QLog.d("TemplatePreviewAdapter", 1, "[predownloadRunnable] to download material, ", ViewHolder.this.W.f30533id);
                            ViewHolder.this.r0();
                            ViewHolder.this.Y.h(ViewHolder.this.W, new a());
                            return;
                        }
                        QLog.d("TemplatePreviewAdapter", 2, "[predownloadRunnable] already download material, ", ViewHolder.this.W.f30533id);
                    }
                }

                /* renamed from: com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter$ViewHolder$1$a */
                /* loaded from: classes21.dex */
                class a implements WinkEditorResourceDownloader.d {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
                    public void onDownloadFinish(boolean z16) {
                    }

                    @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
                    public void onProgressUpdate(int i3) {
                    }
                }
            };
            this.E = (TextView) view.findViewById(R.id.title);
            this.F = (TextView) view.findViewById(R.id.f786147j);
            this.G = (ImageView) view.findViewById(R.id.tew);
            ImageView imageView = (ImageView) view.findViewById(R.id.ak9);
            this.H = imageView;
            if (TemplatePreviewAdapter.this.I) {
                imageView.setVisibility(8);
            }
            this.I = (TextView) view.findViewById(R.id.ugg);
            this.J = (QUIButton) view.findViewById(R.id.f87974vt);
            this.K = (ImageView) view.findViewById(R.id.f87984vu);
            this.U = (LinearLayout) view.findViewById(R.id.jav);
            this.Q = (TextView) view.findViewById(R.id.f111906mh);
            this.P = (URLImageView) view.findViewById(R.id.f1178772m);
            RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) view.findViewById(R.id.kt9);
            this.N = roundCorneredRelativeLayout;
            roundCorneredRelativeLayout.setRadius(ImmersiveUtils.dpToPx(8.0f), ImmersiveUtils.dpToPx(8.0f), ImmersiveUtils.dpToPx(8.0f), ImmersiveUtils.dpToPx(8.0f));
            this.L = (ImageView) view.findViewById(R.id.f1178972o);
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.f1179172q);
            this.R = seekBar;
            seekBar.setOnSeekBarChangeListener(p0());
            r0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A0(MetaMaterial metaMaterial, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Bundle bundle = new Bundle();
            bundle.putInt("JUMP_FROM_KEY", 104);
            bundle.putString("key_content", com.tencent.mobileqq.wink.editor.c.M0(metaMaterial));
            f83.a.c(TemplatePreviewAdapter.this.E, TemplatePreviewAdapter.this.G, bundle);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B0(MetaMaterial metaMaterial, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Bundle bundle = new Bundle();
            bundle.putInt("JUMP_FROM_KEY", 104);
            f83.a.d(metaMaterial, TemplatePreviewAdapter.this.G, bundle, this.Y, new b(metaMaterial));
            TemplatePreviewAdapter.this.x0(this.J, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BEGIN_BUTTON, null, metaMaterial);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C0(MetaMaterial metaMaterial, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (u.a().b()) {
                w53.b.f("TemplatePreviewAdapter", "onShareCLicked too fast");
            } else if (com.tencent.mobileqq.wink.editor.c.T(metaMaterial).equals(MaterialType.AUTO_TEMPLATE)) {
                ((IWinkShareAPI) QRoute.api(IWinkShareAPI.class)).showMaterialSharePanel(p.f(metaMaterial), (Activity) TemplatePreviewAdapter.this.E, QQWinkConstants.AUTO_MATERIAL, this.H);
            } else {
                ((IWinkShareAPI) QRoute.api(IWinkShareAPI.class)).showMaterialSharePanel(p.f(metaMaterial), (Activity) TemplatePreviewAdapter.this.E, QQWinkConstants.LINGGANKU_MATERIAL, this.H);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D0(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseVideoView baseVideoView = this.M;
            if (baseVideoView != null && this.L != null) {
                if (baseVideoView.isPlaying()) {
                    this.M.pause();
                    this.L.setVisibility(0);
                } else {
                    this.M.resume();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E0() {
            new ao().g(this.H, "ae_key_save_share_ling_gan_material");
        }

        private String H0(long j3) {
            if (this.S == null) {
                this.S = new SimpleDateFormat("mm:ss");
            }
            return this.S.format(Long.valueOf(j3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0(int i3, long j3) {
            String H0 = H0(i3);
            String H02 = H0(j3);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(H0);
            spannableStringBuilder.append((CharSequence) " / ").append((CharSequence) H02);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-1), 0, 5, 18);
            this.Q.setText(spannableStringBuilder);
            this.Q.setVisibility(0);
        }

        private void K0(ImageView imageView) {
            ObjectAnimator k06 = k0(imageView, "ScaleX", 0.0f, 1.2f, 210L, 0L);
            ObjectAnimator k07 = k0(imageView, "ScaleY", 0.0f, 1.2f, 210L, 0L);
            imageView.setPivotX(imageView.getWidth() >> 1);
            imageView.setPivotY(imageView.getHeight() >> 1);
            ObjectAnimator k08 = k0(imageView, "ScaleX", 1.2f, 1.0f, 90L, 210L);
            ObjectAnimator k09 = k0(imageView, "ScaleY", 1.2f, 1.0f, 90L, 210L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(k06).with(k07).with(k08).with(k09);
            animatorSet.start();
        }

        private void Q(MetaMaterial metaMaterial) {
            this.G.setImageResource(R.drawable.lot);
            TemplatePreviewAdapter.this.D.e(metaMaterial.f30533id);
            K0(this.G);
            SimpleEventBus.getInstance().dispatchEvent(new FavoriteMaterialEvent(metaMaterial, true));
        }

        private void R(BaseVideoView baseVideoView) {
            Iterator it = TemplatePreviewAdapter.this.J.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == baseVideoView) {
                    return;
                }
            }
            TemplatePreviewAdapter.this.J.add(new WeakReference(baseVideoView));
        }

        private void U(String str) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = aa.f326656a;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                this.P.setImageDrawable(URLDrawable.getDrawable(str, obtain));
                this.P.setVisibility(0);
            } catch (Exception e16) {
                this.P.setVisibility(8);
                QLog.w("TemplatePreviewAdapter", 1, "[bindCover]", e16);
            }
        }

        private void W(final MetaMaterial metaMaterial) {
            if (TemplatePreviewAdapter.this.C.f(metaMaterial.f30533id)) {
                this.G.setImageResource(R.drawable.lot);
            } else {
                this.G.setImageResource(R.drawable.qui_star);
            }
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.w0(metaMaterial, view);
                }
            });
        }

        private void Y(final MetaMaterial metaMaterial) {
            if (TemplatePreviewAdapter.this.D.i(metaMaterial.f30533id)) {
                this.G.setImageResource(R.drawable.lot);
            } else {
                this.G.setImageResource(R.drawable.qui_star);
            }
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.z0(metaMaterial, view);
                }
            });
        }

        private void Z(MetaMaterial metaMaterial) {
            if (QQWinkConstants.TEMPLATE_ID_MAOMEME.equals(metaMaterial.f30533id)) {
                a0(metaMaterial);
            } else {
                b0(metaMaterial);
            }
            MateActivityUIStyle R = com.tencent.mobileqq.wink.editor.c.R(metaMaterial);
            if (R != null && R.getTemplateLibPreviewBtnBg() != null) {
                int[] btnPlaceHolderColors = R.getBtnPlaceHolderColors();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                if (btnPlaceHolderColors != null && btnPlaceHolderColors.length > 0) {
                    obtain.mLoadingDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, btnPlaceHolderColors);
                } else {
                    obtain.mLoadingDrawable = new ColorDrawable(ContextCompat.getColor(TemplatePreviewAdapter.this.E, R.color.qvideo_skin_color_btn_primary_normal));
                }
                obtain.mFailedDrawable = new ColorDrawable(ContextCompat.getColor(TemplatePreviewAdapter.this.E, R.color.qvideo_skin_color_btn_primary_normal));
                this.K.setImageDrawable(URLDrawable.getDrawable(R.getTemplateLibPreviewBtnBg(), obtain));
                this.J.setBackgroundColor(0);
            } else {
                this.K.setImageDrawable(null);
            }
            if (R != null && R.getTemplateLibPreviewBtnText() != null) {
                this.J.setText(R.getTemplateLibPreviewBtnText());
            }
        }

        private void a0(final MetaMaterial metaMaterial) {
            this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.A0(metaMaterial, view);
                }
            });
        }

        private void b0(final MetaMaterial metaMaterial) {
            this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.B0(metaMaterial, view);
                }
            });
        }

        private void c0(final MetaMaterial metaMaterial) {
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.C0(metaMaterial, view);
                }
            });
        }

        private void d0(String str) {
            this.U.removeAllViews();
            for (String str2 : str.split("\uff5c")) {
                TextView textView = new TextView(TemplatePreviewAdapter.this.E);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, TemplatePreviewAdapter.K, 0);
                textView.setPadding(TemplatePreviewAdapter.L, TemplatePreviewAdapter.M, TemplatePreviewAdapter.L, TemplatePreviewAdapter.M);
                textView.setLayoutParams(layoutParams);
                textView.setText(str2);
                textView.setTextSize(2, 14.0f);
                textView.setTextColor(TemplatePreviewAdapter.this.E.getResources().getColor(R.color.qui_common_text_primary));
                textView.setBackgroundResource(R.drawable.qui_common_overlay_light_bg);
                this.U.addView(textView);
            }
        }

        private void e0(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoViewFS(this.itemView.getContext(), 153L, o0(str), null);
            this.M = baseVideoView;
            R(baseVideoView);
            TemplatePreviewAdapter.this.J.add(new WeakReference(this.M));
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TemplatePreviewAdapter.ViewHolder.this.D0(view);
                }
            });
            this.N.addView(this.M, 0, new RelativeLayout.LayoutParams(-1, -1));
            if (TemplatePreviewAdapter.this.F == getAdapterPosition()) {
                G0();
                TemplatePreviewAdapter.this.F = -1;
            }
        }

        private void f0(MetaMaterial metaMaterial) {
            this.G.setImageResource(R.drawable.qui_star);
            TemplatePreviewAdapter.this.D.f(metaMaterial.f30533id);
            SimpleEventBus.getInstance().dispatchEvent(new FavoriteMaterialEvent(metaMaterial, false));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int i0(int i3, int i16, long j3) {
            if (i16 == 0) {
                QLog.w("TemplatePreviewAdapter", 1, "[computeDuration] invalid maxProgress");
                return 0;
            }
            return (int) (((i3 * 1.0f) / i16) * ((float) j3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int j0(long j3, long j16, int i3) {
            if (j16 == 0) {
                QLog.w("TemplatePreviewAdapter", 1, "[computeProgress] invalid totalDuration");
                return 0;
            }
            return (int) (((((float) j3) * 1.0f) / ((float) j16)) * i3);
        }

        private ObjectAnimator k0(View view, String str, float f16, float f17, long j3, long j16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f16, f17);
            ofFloat.setDuration(j3);
            ofFloat.setStartDelay(j16);
            return ofFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(boolean z16, String str) {
            QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(TemplatePreviewAdapter.this.E).p(TemplatePreviewAdapter.this.E.getString(R.string.f241327rk)).n(z16).a();
            this.X = a16;
            a16.setOnDismissListener(new c(str));
        }

        private VideoPlayParam o0(String str) {
            VideoPlayParam videoPlayParam = new VideoPlayParam();
            videoPlayParam.mUrls = new String[]{str};
            videoPlayParam.mVideoFormat = 101;
            videoPlayParam.mIsLocal = false;
            videoPlayParam.mIsLoop = true;
            videoPlayParam.mNeedPlayProgress = true;
            videoPlayParam.mCallback = new v() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter.ViewHolder.5
                @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
                public void onFirstFrameRendered(long j3) {
                    com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.TemplatePreviewAdapter.ViewHolder.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ViewHolder.this.R != null) {
                                ViewHolder.this.R.setVisibility(0);
                            }
                            if (ViewHolder.this.P != null) {
                                ViewHolder.this.P.setVisibility(8);
                            }
                        }
                    });
                }

                @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
                public void onPlayProgress(long j3, long j16) {
                    if (ViewHolder.this.R != null && ViewHolder.this.M != null) {
                        ViewHolder viewHolder = ViewHolder.this;
                        int j06 = viewHolder.j0(j16, viewHolder.M.getVideoDurationMs(), ViewHolder.this.R.getMax());
                        if (j06 >= ViewHolder.this.T) {
                            ViewHolder.this.R.setProgress(j06);
                            ViewHolder.this.T = -1;
                        }
                    }
                }

                @Override // com.tencent.mobileqq.wink.utils.v, com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
                public void onStateChange(long j3, int i3) {
                    if (i3 == 4) {
                        ViewHolder.this.R.setVisibility(0);
                        ViewHolder.this.L.setVisibility(8);
                    }
                }
            };
            videoPlayParam.mSceneId = 163;
            return videoPlayParam;
        }

        private SeekBar.OnSeekBarChangeListener p0() {
            return new d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.Q.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            if (this.Y == null) {
                this.Y = new TemplateJumpImpl(TemplatePreviewAdapter.this.E, new a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s0(String str, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("TemplatePreviewAdapter")) {
                com.tencent.mobileqq.wink.f.l(this.itemView.getContext(), str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w0(MetaMaterial metaMaterial, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TemplatePreviewAdapter.this.C.f(metaMaterial.f30533id)) {
                this.G.setImageResource(R.drawable.qui_star);
                TemplatePreviewAdapter.this.C.b(metaMaterial.f30533id);
                SimpleEventBus.getInstance().dispatchEvent(new FavoriteMaterialEvent(metaMaterial, false));
            } else {
                this.G.setImageResource(R.drawable.lot);
                TemplatePreviewAdapter.this.C.a(metaMaterial.f30533id);
                K0(this.G);
                SimpleEventBus.getInstance().dispatchEvent(new FavoriteMaterialEvent(metaMaterial, true));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x0(MetaMaterial metaMaterial, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            w53.b.f("TemplatePreviewAdapter", "[deleteFavorite] isSuccess:" + z16 + " retCode:" + j3);
            if (z16 && j3 == 0) {
                f0(metaMaterial);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y0(MetaMaterial metaMaterial, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            w53.b.f("TemplatePreviewAdapter", "[sendFavoriteListToServer] isSuccess:" + z16 + " retCode:" + j3);
            if (z16 && j3 == 0) {
                Q(metaMaterial);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z0(final MetaMaterial metaMaterial, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TemplatePreviewAdapter.this.D.i(metaMaterial.f30533id)) {
                o83.a.f422212a.a("libTemplate", metaMaterial.f30533id, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.h
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        TemplatePreviewAdapter.ViewHolder.this.x0(metaMaterial, baseRequest, z16, j3, str, obj);
                    }
                });
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(metaMaterial.f30533id);
                o83.a.f422212a.e("libTemplate", arrayList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.i
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        TemplatePreviewAdapter.ViewHolder.this.y0(metaMaterial, baseRequest, z16, j3, str, obj);
                    }
                });
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void F0() {
            QLog.d("TemplatePreviewAdapter", 2, "[pauseVideo]");
            this.V = false;
            com.tencent.qav.thread.a.e(this.Z);
            BaseVideoView baseVideoView = this.M;
            if (baseVideoView != null) {
                baseVideoView.pause();
                this.M.seekTo(0);
            }
            SeekBar seekBar = this.R;
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
            this.T = -1;
        }

        public void G0() {
            QLog.d("TemplatePreviewAdapter", 2, "[playVideo]");
            if (this.W == null) {
                QLog.w("TemplatePreviewAdapter", 1, "[playVideo] invalid material");
                return;
            }
            this.V = true;
            if (this.M == null) {
                e0(com.tencent.mobileqq.wink.editor.c.S0(this.W));
            }
            BaseVideoView baseVideoView = this.M;
            if (baseVideoView != null) {
                baseVideoView.play();
            }
            com.tencent.qav.thread.a.a(this.Z, 2000L);
        }

        public void I0() {
            this.H.post(new Runnable() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.c
                @Override // java.lang.Runnable
                public final void run() {
                    TemplatePreviewAdapter.ViewHolder.this.E0();
                }
            });
        }

        public void L0() {
            F0();
            QLog.d("TemplatePreviewAdapter", 2, "[stopVideo]");
            BaseVideoView baseVideoView = this.M;
            if (baseVideoView != null) {
                baseVideoView.releasePlayer(false);
                this.M.setVisibility(8);
            }
            this.M = null;
            ImageView imageView = this.L;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            URLImageView uRLImageView = this.P;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
        }

        public void T(MetaMaterial metaMaterial) {
            this.W = metaMaterial;
            this.E.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            this.I.setText(com.tencent.mobileqq.wink.editor.c.O(metaMaterial));
            d0(com.tencent.mobileqq.wink.editor.c.B0(metaMaterial));
            if (o83.a.f422212a.d()) {
                Y(metaMaterial);
            } else {
                W(metaMaterial);
            }
            c0(metaMaterial);
            U(com.tencent.mobileqq.wink.editor.c.Z(metaMaterial));
            Z(metaMaterial);
            if (TemplatePreviewAdapter.this.F == getAdapterPosition()) {
                I0();
                e0(com.tencent.mobileqq.wink.editor.c.S0(metaMaterial));
            }
            final String G = com.tencent.mobileqq.wink.editor.c.G(metaMaterial);
            if (TextUtils.isEmpty(G)) {
                this.F.setVisibility(8);
            } else {
                this.F.setVisibility(0);
                this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.adapter.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TemplatePreviewAdapter.ViewHolder.this.s0(G, view);
                    }
                });
            }
        }
    }

    public TemplatePreviewAdapter(Context context, List<MetaMaterial> list, int i3, String str, WinkTemplatePreviewFragment winkTemplatePreviewFragment) {
        this.E = context;
        this.f326420m = list;
        this.F = i3;
        this.G = str;
        if (this.H == null) {
            this.H = QQPermissionFactory.getQQPermission(winkTemplatePreviewFragment);
        }
        this.I = WinkContext.INSTANCE.d().u("QZONE");
    }

    private void w0(View view, String str, Map<String, Object> map, MetaMaterial metaMaterial) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        if (metaMaterial != null) {
            VideoReport.setElementReuseIdentifier(view, metaMaterial.f30533id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(View view, String str, Map<String, Object> map, MetaMaterial metaMaterial) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (metaMaterial != null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            buildElementParams.put("xsj_template_id", metaMaterial.f30533id);
        }
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.reportEvent("dt_clck", view, map);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    public void A0(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        QQPermission qQPermission = this.H;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(i3, strArr, iArr);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        viewHolder.L0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MetaMaterial> list = this.f326420m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void v0() {
        Iterator<WeakReference<BaseVideoView>> it = this.J.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            BaseVideoView baseVideoView = it.next().get();
            if (baseVideoView != null) {
                baseVideoView.releasePlayer(false);
                i3++;
            }
        }
        QLog.d("TemplatePreviewAdapter", 1, "[clearVideoView] clear count=" + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        MetaMaterial metaMaterial = this.f326420m.get(i3);
        viewHolder.T(metaMaterial);
        HashMap hashMap = new HashMap();
        w0(viewHolder.H, "em_xsj_share_button", hashMap, metaMaterial);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        w0(viewHolder.G, "em_xsj_collect_button", hashMap, metaMaterial);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
        hashMap.put("xsj_template_id", metaMaterial.f30533id);
        Map<String, Object> a16 = com.tencent.mobileqq.wink.report.f.f326266a.a((Activity) this.E);
        if (a16 != null && a16.size() > 0) {
            for (Map.Entry<String, Object> entry : a16.entrySet()) {
                WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
            }
        }
        w0(viewHolder.J, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BEGIN_BUTTON, hashMap, metaMaterial);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hrv, viewGroup, false));
    }
}
