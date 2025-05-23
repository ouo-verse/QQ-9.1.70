package com.tencent.mobileqq.guild.channel.create.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;

/* loaded from: classes12.dex */
public class QQGuildAppPreviewFragment extends BaseCreateSubChannelFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private static int N = 20;
    private static float P = 0.60956174f;
    private TextView F;
    private ViewPager G;
    private LinearLayout H;
    private Button I;
    private int J = 0;
    private int K;
    private int L;
    private List<String> M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QQGuildAppPreviewFragment qQGuildAppPreviewFragment = QQGuildAppPreviewFragment.this;
            qQGuildAppPreviewFragment.K = qQGuildAppPreviewFragment.G.getMeasuredHeight();
            QQGuildAppPreviewFragment.this.L = (int) (r0.K * QQGuildAppPreviewFragment.P);
            int measuredWidth = QQGuildAppPreviewFragment.this.G.getMeasuredWidth() - QQGuildUIUtil.f(QQGuildAppPreviewFragment.N);
            QLog.i("Guild.c.create.QQGuildAppPreviewFragment", 1, "onGlobalLayout height = " + QQGuildAppPreviewFragment.this.G.getHeight() + ", measuredHeight = " + QQGuildAppPreviewFragment.this.G.getMeasuredHeight() + ", measuredWidth = " + QQGuildAppPreviewFragment.this.G.getMeasuredWidth() + ", maxWidth = " + measuredWidth);
            if (QQGuildAppPreviewFragment.this.L > measuredWidth) {
                QQGuildAppPreviewFragment.this.L = measuredWidth;
                QQGuildAppPreviewFragment.this.K = (int) (r0.L / QQGuildAppPreviewFragment.P);
            }
            int measuredWidth2 = (QQGuildAppPreviewFragment.this.G.getMeasuredWidth() - QQGuildAppPreviewFragment.this.L) / 2;
            QQGuildAppPreviewFragment.this.G.setPadding(measuredWidth2, 0, measuredWidth2, 0);
            QQGuildAppPreviewFragment.this.G.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            QQGuildAppPreviewFragment.this.G.setAdapter(new b());
            QQGuildAppPreviewFragment.this.G.clearOnPageChangeListeners();
            QQGuildAppPreviewFragment.this.G.addOnPageChangeListener(QQGuildAppPreviewFragment.this);
            QQGuildAppPreviewFragment.this.G.setCurrentItem(QQGuildAppPreviewFragment.this.J);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends PagerAdapter {
        b() {
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
            return QQGuildAppPreviewFragment.this.M.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(QQGuildAppPreviewFragment.this.getContext()).inflate(R.layout.eun, (ViewGroup) null);
            RoundRectImageView roundRectImageView = (RoundRectImageView) inflate.findViewById(R.id.f27290fu);
            ViewGroup.LayoutParams layoutParams = roundRectImageView.getLayoutParams();
            layoutParams.height = QQGuildAppPreviewFragment.this.K;
            layoutParams.width = QQGuildAppPreviewFragment.this.L;
            roundRectImageView.setLayoutParams(layoutParams);
            roundRectImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0f), 1);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = QQGuildAppPreviewFragment.this.L;
            obtain.mRequestHeight = QQGuildAppPreviewFragment.this.K;
            obtain.mLoadingDrawable = QQGuildAppPreviewFragment.this.getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
            obtain.mFailedDrawable = QQGuildAppPreviewFragment.this.getContext().getResources().getDrawable(R.drawable.guild_create_subchannel_dialog_bg);
            roundRectImageView.setImageDrawable(URLDrawable.getDrawable((String) QQGuildAppPreviewFragment.this.M.get(i3), obtain));
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

    private void Ah() {
        List<String> list = this.M;
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < this.M.size(); i3++) {
                View view = new View(getContext());
                view.setBackgroundResource(R.drawable.guild_page_indicate_dot);
                view.setSelected(false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(QQGuildUIUtil.f(6.0f), QQGuildUIUtil.f(6.0f));
                layoutParams.leftMargin = QQGuildUIUtil.f(4.0f);
                layoutParams.rightMargin = QQGuildUIUtil.f(4.0f);
                this.H.addView(view, layoutParams);
            }
            this.H.getChildAt(0).setSelected(true);
            return;
        }
        QLog.e("Guild.c.create.QQGuildAppPreviewFragment", 1, "setIndicateDot previewUrls is null");
    }

    private void Bh() {
        List<String> list = this.M;
        if (list != null && list.size() != 0) {
            this.G.setPageMargin(QQGuildUIUtil.f(N));
            this.G.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        } else {
            QLog.e("Guild.c.create.QQGuildAppPreviewFragment", 1, "setPageView previewUrls is null");
        }
    }

    private void initData() {
        this.M = this.D.f214825i.getStringArrayList("previewUrls");
    }

    private void initView() {
        this.F = (TextView) this.C.findViewById(R.id.t2v);
        this.G = (ViewPager) this.C.findViewById(R.id.f27280ft);
        this.H = (LinearLayout) this.C.findViewById(R.id.xmc);
        this.I = (Button) this.C.findViewById(R.id.bbl);
        this.F.setOnClickListener(this);
        this.I.setOnClickListener(this);
        Ah();
        Bh();
    }

    public static QQGuildAppPreviewFragment zh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildAppPreviewFragment qQGuildAppPreviewFragment = new QQGuildAppPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildAppPreviewFragment.setArguments(bundle);
        return qQGuildAppPreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eft;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    protected void init() {
        initData();
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            int id5 = view.getId();
            if (id5 == R.id.t2v) {
                BaseDialogFragment baseDialogFragment = this.E;
                if (baseDialogFragment != null) {
                    baseDialogFragment.sh();
                }
            } else if (id5 == R.id.bbl && this.E != null) {
                QQGuildSubChannelCreateDialogFragment Eh = QQGuildSubChannelCreateDialogFragment.Eh(this.D);
                Eh.Dh(this.E.F);
                this.E.th();
                Eh.show(getActivity().getSupportFragmentManager(), "QQGuildAppSubChannelCreateDialogFragment");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Bh();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        this.H.getChildAt(this.J).setSelected(false);
        this.H.getChildAt(i3).setSelected(true);
        this.J = i3;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
