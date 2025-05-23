package com.tencent.mobileqq.guild.setting.guildwelcome.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.setting.guildwelcome.fragment.GuildWelcomeGuideDialogFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuidePageInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuidePageInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.AppSetting;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wh2.cb;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildWelcomeGuideDialogFragment extends GuildBaseBottomSheetFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private View D;
    private LinearLayout E;
    private View F;
    private ViewPager G;
    private LinearLayout H;
    private TextView I;
    private int K;
    private int L;
    private List<e> M;
    private c P;
    private String S;
    private String T;
    private int J = 0;
    private Map<String, URLDrawable.URLDrawableOptions> N = new HashMap();
    private int Q = 1;
    private boolean R = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            GuildWelcomeGuideDialogFragment guildWelcomeGuideDialogFragment = GuildWelcomeGuideDialogFragment.this;
            guildWelcomeGuideDialogFragment.K = guildWelcomeGuideDialogFragment.G.getMeasuredHeight() - cx.a(90.0f);
            GuildWelcomeGuideDialogFragment.this.L = (int) (r0.K * 1.2316716f);
            int measuredWidth = GuildWelcomeGuideDialogFragment.this.G.getMeasuredWidth();
            if (GuildWelcomeGuideDialogFragment.this.L > measuredWidth) {
                GuildWelcomeGuideDialogFragment.this.L = measuredWidth;
                GuildWelcomeGuideDialogFragment.this.K = (int) (r0.L / 1.2316716f);
            }
            GuildWelcomeGuideDialogFragment.this.G.setPadding(0, 0, 0, 0);
            GuildWelcomeGuideDialogFragment.this.G.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GuildWelcomeGuideDialogFragment.this.G.setAdapter(new d());
            GuildWelcomeGuideDialogFragment.this.G.setOnPageChangeListener(GuildWelcomeGuideDialogFragment.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class d extends PagerAdapter {
        d() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (obj != null && viewGroup != null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return GuildWelcomeGuideDialogFragment.this.M.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(GuildWelcomeGuideDialogFragment.this.getContext()).inflate(R.layout.efv, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.f109166f3)).setText(((e) GuildWelcomeGuideDialogFragment.this.M.get(i3)).f234568b);
            ((TextView) inflate.findViewById(R.id.f111016k3)).setText(((e) GuildWelcomeGuideDialogFragment.this.M.get(i3)).f234569c);
            RoundRectImageView roundRectImageView = (RoundRectImageView) inflate.findViewById(R.id.f27290fu);
            ViewGroup.LayoutParams layoutParams = roundRectImageView.getLayoutParams();
            layoutParams.height = GuildWelcomeGuideDialogFragment.this.K;
            layoutParams.width = GuildWelcomeGuideDialogFragment.this.L;
            roundRectImageView.setLayoutParams(layoutParams);
            roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            roundRectImageView.setCornerRadiusAndMode(cx.a(8.0f), 1);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = GuildWelcomeGuideDialogFragment.this.L;
            obtain.mRequestHeight = GuildWelcomeGuideDialogFragment.this.K;
            obtain.mLoadingDrawable = GuildWelcomeGuideDialogFragment.this.getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
            obtain.mFailedDrawable = GuildWelcomeGuideDialogFragment.this.getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
            GuildWelcomeGuideDialogFragment guildWelcomeGuideDialogFragment = GuildWelcomeGuideDialogFragment.this;
            roundRectImageView.setImageDrawable(guildWelcomeGuideDialogFragment.Bh(((e) guildWelcomeGuideDialogFragment.M.get(i3)).f234567a, obtain));
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f234567a;

        /* renamed from: b, reason: collision with root package name */
        public String f234568b;

        /* renamed from: c, reason: collision with root package name */
        public String f234569c;

        public e(String str, String str2, String str3) {
            this.f234567a = str;
            this.f234568b = str2;
            this.f234569c = str3;
        }
    }

    private int Ah() {
        Context context;
        if (getContext() != null) {
            context = getContext();
        } else {
            context = BaseApplication.getContext();
        }
        int a16 = bv.a(context);
        if (a16 <= 0) {
            return QQGuildUIUtil.f(466.0f);
        }
        return (int) (a16 * 0.67511016f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLDrawable Bh(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (str.isEmpty()) {
            return null;
        }
        this.N.put(str, uRLDrawableOptions);
        return URLDrawable.getDrawable(str, uRLDrawableOptions);
    }

    private void Ch() {
        this.G.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        List<e> list = this.M;
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < this.M.size(); i3++) {
                View view = new View(getContext());
                if (QQTheme.isNowThemeIsNight()) {
                    view.setBackgroundResource(R.drawable.guild_welcome_dialog_indicate_night);
                } else {
                    view.setBackgroundResource(R.drawable.guild_welcome_dialog_indicate);
                }
                view.setSelected(false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(6.0f), cx.a(6.0f));
                layoutParams.leftMargin = cx.a(4.0f);
                layoutParams.rightMargin = cx.a(4.0f);
                this.H.addView(view, layoutParams);
            }
            this.H.getChildAt(0).setSelected(true);
            return;
        }
        QLog.e("GuildWelcomeGuideDialogFragment", 1, "initView previewUrls is null");
    }

    private void Dh(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.f_f, viewGroup, true);
        this.D = inflate;
        this.F = inflate.findViewById(R.id.f164814ty2);
        this.E = (LinearLayout) this.D.findViewById(R.id.u8b);
        this.G = (ViewPager) this.D.findViewById(R.id.f27280ft);
        this.H = (LinearLayout) this.D.findViewById(R.id.xmc);
        this.I = (TextView) this.D.findViewById(R.id.yj8);
        if (QQTheme.isNowThemeIsNight()) {
            this.I.setBackground(getContext().getDrawable(R.drawable.guild_welcome_guide_dialog_btn_bg_night));
        } else {
            this.I.setBackground(getContext().getDrawable(R.drawable.guild_welcome_guide_dialog_btn_bg));
        }
        this.F.setOnClickListener(new View.OnClickListener() { // from class: zz1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildWelcomeGuideDialogFragment.this.onClick(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: zz1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildWelcomeGuideDialogFragment.this.onClick(view);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
        layoutParams.height = Ah();
        this.E.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(int i3, String str, IGProGetGuidePageInfoRsp iGProGetGuidePageInfoRsp) {
        QLog.i("GuildWelcomeGuideDialogFragment", 1, "[loadContentData] getGuidePageInfo result: " + i3 + ", msg: " + str);
        if (i3 == 0 && iGProGetGuidePageInfoRsp != null && iGProGetGuidePageInfoRsp.getGuidePage() != null) {
            Gh(iGProGetGuidePageInfoRsp.getGuidePage());
        } else {
            Hh();
        }
    }

    private void Fh() {
        QLog.i("GuildWelcomeGuideDialogFragment", 1, "[loadContentData] moduleId: " + this.S + ", appId: " + this.T);
        if (!TextUtils.isEmpty(this.S) && !TextUtils.isEmpty(this.T)) {
            try {
                ((IGPSService) bz.b(IGPSService.class)).getGuidePageInfo(Long.parseLong(this.T), this.S, new cb() { // from class: zz1.a
                    @Override // wh2.cb
                    public final void a(int i3, String str, IGProGetGuidePageInfoRsp iGProGetGuidePageInfoRsp) {
                        GuildWelcomeGuideDialogFragment.this.Eh(i3, str, iGProGetGuidePageInfoRsp);
                    }
                });
                return;
            } catch (NumberFormatException unused) {
                QLog.w("GuildWelcomeGuideDialogFragment", 1, "[loadContentData] failed. invalid appId");
                Hh();
                return;
            }
        }
        Hh();
    }

    private void Gh(ArrayList<IGProGuidePageInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<IGProGuidePageInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IGProGuidePageInfo next = it.next();
            String imgDayMode = next.getImages().getImgDayMode();
            String imgNightMode = next.getImages().getImgNightMode();
            if (GuildThemeManager.f235286a.b()) {
                imgDayMode = imgNightMode;
            }
            arrayList2.add(new e(imgDayMode, next.getTitle(), next.getDesc()));
        }
        this.M = arrayList2;
        Ch();
    }

    private void Hh() {
        this.M = yh();
        Ch();
    }

    private void Ih() {
        for (Map.Entry<String, URLDrawable.URLDrawableOptions> entry : this.N.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                URLDrawable.removeMemoryCacheByUrl(entry.getKey(), entry.getValue());
            }
        }
    }

    private void Kh() {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.D, "pg_sgrp_channel_introduce");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        if (this.Q == 3) {
            str = "functional_open_tab_guild";
        } else {
            str = "functional_my_config";
        }
        hashMap.put("sgrp_stream_pgin_source_name", str);
        VideoReport.setPageParams(this.D, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(this.D, PageReportPolicy.REPORT_NONE);
        ch.Y0(this.I, "em_sgrp_channel_introduce_start", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", this.I, null);
    }

    private List<e> yh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(zh(1), getString(R.string.f140680em), getString(R.string.f140690en)));
        arrayList.add(new e(zh(2), getString(R.string.f140700eo), getString(R.string.f140710ep)));
        arrayList.add(new e(zh(3), getString(R.string.f140720eq), getString(R.string.f140730er)));
        arrayList.add(new e(zh(4), getString(R.string.f140740es), getString(R.string.f140750et)));
        return arrayList;
    }

    @SuppressLint({"DefaultLocale"})
    private String zh(int i3) {
        if ((i3 > 0 && i3 <= 4) || AppSetting.isPublicVersion()) {
            if (GuildThemeManager.f235286a.b()) {
                return String.format("https://downv6.qq.com/innovate/guild/tips/GuildBegginerGuideImage_dark_%d.png", Integer.valueOf(i3));
            }
            return String.format("https://downv6.qq.com/innovate/guild/tips/GuildBegginerGuideImage_%d.png", Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("invalid index of " + i3 + " in 4 pages");
    }

    public void Jh(c cVar) {
        this.P = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            if (view == this.F) {
                dismissAllowingStateLoss();
            } else if (view == this.I) {
                this.R = true;
                dismissAllowingStateLoss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getBehavior().setState(3);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.S = arguments.getString("template_id");
            this.T = arguments.getString("appid");
        }
        Dh(layoutInflater, viewGroup);
        Fh();
        View view = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.w("GuildWelcomeGuideDialogFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Ih();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        String str;
        HashMap hashMap = new HashMap();
        if (this.R) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("sgrp_clck_place", str);
        VideoReport.reportEvent("clck", this.I, hashMap);
        super.onDismiss(dialogInterface);
        c cVar = this.P;
        if (cVar != null) {
            cVar.onDismiss();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        for (int i16 = 0; i16 < this.M.size(); i16++) {
            this.H.getChildAt(i16).setSelected(false);
        }
        this.H.getChildAt(i3).setSelected(true);
        this.J = i3;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoReport.reportPgOut(this.D);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoReport.reportPgIn(this.D);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.D.getParent()).setBackgroundColor(0);
        BottomSheetBehavior<FrameLayout> behavior = ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior();
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Kh();
        super.onViewCreated(view, bundle);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 4) {
                GuildWelcomeGuideDialogFragment.this.dismissAllowingStateLoss();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
